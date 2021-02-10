package com.study;

/**
 * @ClassName TestDomicProxy
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/10
 * @Version V1.0
 **/
public class TestDomicProxy {
    public static void main(String[] args) {
        //代理目标类
        DynamicProxy dynamicProxy = new DynamicProxy(new ServiceImpl02());

        //获取代理
        StaticProxyService proxy = (StaticProxyService) dynamicProxy.getProxy();

        //目标类的引用
        proxy.query(1);

    }
}
