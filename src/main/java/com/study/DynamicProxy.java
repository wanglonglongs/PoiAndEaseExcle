package com.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @ClassName DynamicProxy
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/10
 * @Version V1.0
 **/
public class DynamicProxy implements InvocationHandler {
    //定义一个目标类
    private Object target;//目标类的引用

    public DynamicProxy(Object target) {
        this.target = target;
    }

    //产生代理类的方法(产生动态代理类)
    public Object getProxy(){
        //返回的就是需要的代理          参数一 类加载器  参数二 目标类实现的所有接口数组 参数三 实现了 InvocationHandler接口的对象
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    //执行目标类的方法 //！！增强方法写这里 执行前后
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        EntityLog entityLog = new EntityLog();
        entityLog.setStuId(Integer.parseInt(args[0].toString()));
        entityLog.setXingxi("查询信息");
        entityLog.setRelust("成功日志结果");
        entityLog.setCreateDate(new Date());
        //当有多个目标类，可以通过类名来区分 也可以通过判断类型 instanceof
        entityLog.setType(target.getClass().toString());
        //也可以直接判断类型
        if (target instanceof ServiceImpl01){
            entityLog.setType("01");
        }
        if (target instanceof ServiceImpl02){
            entityLog.setType("02");
        }
        //执行目标类的方法
        result = method.invoke(target,args);
        return result;
    }
}
