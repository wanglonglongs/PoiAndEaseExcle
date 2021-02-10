package com.study;

/**
 * @ClassName StaticProxyTest
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/10
 * @Version V1.0
 **/
public class StaticProxyTest {
    //增加查询方法的行为
    public static void main(String[] args) {
        StaticProxyService proxyService = new StaticProxy(new ServiceImpl02());
        proxyService.query(1);
    }
}
