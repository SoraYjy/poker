package com.sora.poker.common.utils;

import lombok.Data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;

/**
 * Created by yujingyi on 2017/11/3.
 */
public class XmlUtils {

    static public <T> T readXml(String xml, Class<T> clazz) {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String xml = "<xml><list>[\"dddd\",\"eeee\",\"ffff\"]</list><myName>bbb</myName><id>dad</id></xml>";
        TestParam testParam = readXml(xml, TestParam.class);
        System.out.println(JSONUtil.jsonEncode(testParam));
    }

    @Data
    @XmlRootElement(name = "xml")
    @XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
    static class TestParam {

        private String id;

//        @XmlElement(name = "myName")
        private String name;

        private String girlList;

        public boolean isSuccess() {
            return true;
        }


    }
}
