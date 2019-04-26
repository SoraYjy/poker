package com.sora.poker.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by yujingyi on 2017/5/6.
 */
@Log4j2
public class JSONUtil {

    @SuppressWarnings("unchecked")
    public static Map<String ,Object> decodeJsonToMap(String json) {
        if(StringUtils.isEmpty(json)){
            return null;
        }
        //不是json
        json = StringUtils.trim(json);
        if(!StringUtils.startsWith(json, "{") && !StringUtils.startsWith(json, "[")) {
            log.error("不是json： " + json);
            return null;
        }
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (JsonParseException e) {
            log.error("解析JSON错误：" + json, e);
        } catch (JsonMappingException e) {
            log.error("解析JSON错误：" + json, e);
        } catch (IOException e) {
            log.error("解析JSON错误：" + json, e);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static List<Object> decodeJsonToList(String json) {
        try {
            return objectMapper.readValue(json, List.class);
        } catch (JsonParseException e) {
            log.error("解析JSON错误：" + json, e);
        } catch (JsonMappingException e) {
            log.error("解析JSON错误：" + json, e);
        } catch (IOException e) {
            log.error("解析JSON错误：" + json, e);
        }
        return null;
    }

    /**
     * Decode a json string to T object
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T decodeJson(String json, Class<T> clazz) {
        if(json == null) {
            return null;
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonParseException e) {
            log.error("解析JSON错误：" + json, e);
        } catch (JsonMappingException e) {
            log.error("解析JSON错误：" + json, e);
        } catch (IOException e) {
            log.error("解析JSON错误：" + json, e);
        }
        return null;
    }

    public static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    public static String jsonEncode(Object obj) {
        try{
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return objectMapper.writeValueAsString(obj);
        }catch(IOException ex){
            log.error("生成JSON错误：" + obj.getClass(), ex);
        }
        return null;
    }

    private static final ObjectMapper allObjectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    public static String jsonEncodeAllFields(Object obj) {
        try{
            return allObjectMapper.writeValueAsString(obj);
        }catch(IOException ex){
            log.error("生成JSON错误：" + obj.getClass(), ex);
        }
        return null;
    }
}
