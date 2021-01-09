package com.wn32.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroMd5Utils {

    /**
     *
     * @param hashAlgorithmName  加密算法
     * @param credentials        原始密码
     * @param salt               盐值
     * @param hashIterations     加密次数
     * @return
     */
    public static String getPwd(String hashAlgorithmName,Object credentials,Object salt,int hashIterations){

        //Object credentials = new char[]{'1','2','3','4','5','6'};
        //-- salt翻译是盐的意思。没有salt就是普通的Md5加密，有了salt就是Md5盐值加密
        //-- 为什么要有盐？因为在没有盐的情况下，相同的密码加密后的密文是一致的，
        //-- 我们希望可以像炒菜一样加点配料让相同的密码，加密后得到的密码是不一致！
        //-- 这个配料就被叫做盐值，往往选择用户名做盐值（因为用户名是唯一的！）
        return new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations).toString();
    }


    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123123";
        int hashIterations = 1000;
        Object salt = "tom";
        String pwd = getPwd(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(pwd);
    }

}
