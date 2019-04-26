package com.sora.poker.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * Created by yujingyi on 2017/9/12.
 */
public class SignUtil {


    private static final String ENCODING = "utf-8";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    private static final int DEFAULT_BUFFER_SIZE = 8192;

    /**
     * SHA256WithRSA签名
     *
     * @param data
     * @param privateKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    public static String sign256(String data, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException,
            SignatureException, UnsupportedEncodingException {

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);

        signature.initSign(privateKey);

        signature.update(data.getBytes(ENCODING));

        return new String(Base64.encodeBase64(signature.sign()));
    }

    public static String sign256(String data, String privateKey) throws InvalidKeyException, SignatureException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        return sign256(data, getPrivateKey(privateKey));
    }

    public static boolean verify256(String data, byte[] sign, PublicKey publicKey) {
        if (data == null || sign == null || publicKey == null) {
            return false;
        }

        try {
            Signature signetcheck = Signature.getInstance(SIGNATURE_ALGORITHM);
            signetcheck.initVerify(publicKey);
            signetcheck.update(data.getBytes("UTF-8"));
            return signetcheck.verify(sign);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 二进制数据编码为BASE64字符串
     *
     * @param bytes
     * @return
     */
    public static String encodeBase64(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }

    /**
     * BASE64解码
     *
     * @param bytes
     * @return
     */
    public static byte[] decodeBase64(byte[] bytes) {
        byte[] result = null;
        try {
            result = Base64.decodeBase64(bytes);
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    /**
     * @param privateKey
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String privateKey) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] publicBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    public static void main(String[] args) {
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDLWjZPUk7PwH55+COlRyjXdaI/+czdPFHLLgp3G4KFe/yARBqht2bPcomJr3Krl2EE9JUPkg9yU9M33LTeUpBmVrLc8DxAQCz30McXTN8s/6h5Ri3vkapxsnjcMfSx6pYDoDZbcmvj7lC3YIzZNzdoAq2yNW2uQ5WwP0yPxn/WByJDmJ1Xh0F+oew0uO4TGGmKmcXyL6hxZf364XuUEQyuxNRlYqcqp9mbeGooJFvVvQGX9jmPpk4rji62wlBDDe0pI93y79oXaJn2XDoQfnjANQ4yJbVKpy+u45Ulu1oU7WNQvj1yLNwSoTPugMIOMOjzmjmfpAk5XItyDMrViAYZAgMBAAECggEADEGdsF43ndHuTY+lJlsJnSLb6ps1u8fc7jASNWeVEFKOv3RbXo/dRHeUzpWihbEUCeZr7YpSIAPpYR6OUDANv/1Nvn9EQmMb0rvkpATgFqg6EUUnk57l9QBaxHrGUsrey80mOZDF6/D7MHJDSvxG/J/ctDcAK1arePn3tVqzbcTYw6YnpmxcxC6x0zQ2txZm0qnOCIw7/gFLCPN75RAfl1Ajp16llugRbB/++XDmXFT3azRH7bW3NZBQ71QSOY4QFT/gtlbBZddTdREJOy9iP5yYvcwMhUCKhpmG6pr3igvtOsCCDR46n0fMUmKit+rmHVRBBYADkPAljkShnG6yWQKBgQDwJfKHJeO94/AVUVIGI2ttNLz3rw02nqgiYXSadOjn4yxN5mNpsNi15z3BoEjP3POsXPnM/P3cvo7fC5c7nxI2Xq812YptQbZNpehcqduMjpXwpqXUXjvev9mFeBqO7esXEIPrU0bunno/uBo7IqPEHp14m1J0Ci9LFDnDNPIcfwKBgQDYxnwBaszqW5rEOsN1yTxZ+1jOoNUn7JUW8xbBt9kpoLV/ZhcoYGz+4R2NWNBIXB6CdPIcVqq3d6gskIfq7VRl0p/SmcE2nWT11QWrGAvzpbTeZPN6ssyLtRh6/scm25rHN24/Fzt+ZqT4emOaligJugCervYhoYU7SNBQyzXxZwKBgQDOWx1TSpivJH26I73C7o6yMX4rq21EQQMjP/ENhGZaVFhOvCkyubcOYB0uE8hdbXSp6N7yaXbPR6PHP9N9dQwWUjhmon8TsUKw6F6JuZ+h4SgwuVKH8U2q89o7mV/g78pycEubXFz4UI+lz1Ii/HoS3WfdKkKo2dOXxVJ5Tja5iwKBgQDMja9iXvdyhnJqjND4iqYKeuV4RcgeXl7pQwXMUsH3SBE8YIelsCfp819Bi/cu8M5RaC02lImPirgFJXU8OCuV0cTCpBfwg2FLoHIy2wQcK9earEQdGi9t/btWBKjEgCFzr1i27CNVyWIOnt7ydpLdask+8/aKEbJ5GOKJ+teyLQKBgArGVFG4dCZdzwyHr4saBtJzDKna55TSmIo8w+LC7RpIxXCZLBF7HYhitACa/Wed+QgYwtcXRr6MRKxHZtmmKTkUGKFaHmqNReDBDQZ+CWbotfFv9oTRha+00VeWZtOsN2KvfE/LMKjGLBrEjDyZEqLGLEnqWymh+bw6oy6x7ATb";
        String params = "a=123";

        try {
            System.out.println(sign256(params, getPrivateKey(privateKey)));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
