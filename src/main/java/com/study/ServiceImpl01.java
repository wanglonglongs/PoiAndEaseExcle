package com.study;

/**
 * @ClassName ServiceImpl01
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/10
 * @Version V1.0
 **/
public class ServiceImpl01 implements StaticProxyService{
    //目标类一
    public void query(Integer stuId) {
        System.out.println("01实现类");
    }
}
