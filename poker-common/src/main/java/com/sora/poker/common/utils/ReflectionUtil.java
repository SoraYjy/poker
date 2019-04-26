package com.sora.poker.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 17/2/3 下午5:47 aiguoxin 说明: 反射工具类
 */
public class ReflectionUtil {

    private static Set<Field> getClassAllFields(Class clazz, Set<Field> allGenericFields) {

        // 如果clazz为空则直接返回
        if (clazz == null)
            return allGenericFields;

        Object parent = clazz.getGenericSuperclass();
        // 如果有父类并且父类不是Object 则递归调用
        if (parent != null && !((Class) parent).getName().equals("Object")) {
            getClassAllFields((Class) parent, allGenericFields);
        }

        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {// 如果clazz存在声明的属性
            for (int i = 0; i < fields.length; i++)
                allGenericFields.add(fields[i]);
        }
        // 存在父类则递归调用
        return allGenericFields;
    }

    /**
     * 获取类所有字段
     * @param clazz
     * @return
     */
    public static Set<Field> getClassAllFields(Class clazz) {
        Set<Field> allGenericFields = new HashSet<Field>();
        return getClassAllFields(clazz, allGenericFields);
    }

    /**
     * 获取类方法名
     * @param field
     * @return
     * @throws Exception
     */
    public static String getMethodName(String field) throws Exception {
        byte[] items = field.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    /**
     * 执行某方向(不带参数)
     * @param owner
     * @param methodName
     * @return
     * @throws Exception
     */
    public static Object invokeMethod(Object owner, String methodName) throws Exception {
        return invokeMethod(owner, methodName, new Object[0]);
    }

    /**
     * 执行某方法
     * @param owner
     * @param methodName
     * @param args
     * @return
     * @throws Exception
     */
    public static Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        Class ownerClass = owner.getClass();

        Class[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }

        Method method = ownerClass.getMethod(methodName,argsClass);
        return method.invoke(owner, args);
    }

    /**
     * 将object转化为map
     * @param obj
     * @param reserveNull 是否保留null字段
     * @param underScore 是否将map的key转化为下划线大写
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object obj, boolean reserveNull, boolean underScore) {
        if(obj == null){
            return null;
        }
        //获取关联的所有类，本类以及所有父类
        boolean ret = true;
        Class oo = obj.getClass();
        List<Class> clazzs = new ArrayList<Class>();
        while(ret){
            clazzs.add(oo);
            oo = oo.getSuperclass();
            if(oo == null || oo == Object.class)break;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        try {
            for(int i=0;i<clazzs.size();i++){
                Field[] declaredFields = clazzs.get(i).getDeclaredFields();
                for (Field field : declaredFields) {
                    int mod = field.getModifiers();
                    //过滤 static 和 final 类型
                    if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                        continue;
                    }
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    if (underScore) {
                        fieldName = CamelUtil.camelToUnderScore(fieldName);
                    }
                    if (field.get(obj) != null || reserveNull) {
                        map.put(fieldName, field.get(obj));
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return map;
    }

    public static Object mapToObject(Map<String, String> map, Class<?> beanClass) throws Exception {
        if (map == null || map.size()<=0)
            return null;

        Object obj = beanClass.newInstance();
        //获取关联的所有类，本类以及所有父类
        boolean ret = true;
        Class oo = obj.getClass();
        List<Class> clazzs = new ArrayList<Class>();
        while(ret){
            clazzs.add(oo);
            oo = oo.getSuperclass();
            if(oo == null || oo == Object.class)break;
        }

        for(int i=0;i<clazzs.size();i++){
            Field[] fields = clazzs.get(i).getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }
                //由字符串转换回对象对应的类型
                if (field != null) {
                    field.setAccessible(true);
                    field.set(obj, map.get(field.getName()));
                }
            }
        }
        return obj;
    }
}
