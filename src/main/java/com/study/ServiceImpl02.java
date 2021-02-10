package com.study;

/**
 * @ClassName ServiceImpl01
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/10
 * @Version V1.0
 **/
public class ServiceImpl02 implements StaticProxyService{
    //目标类二
    public void query(Integer stuId) {
        System.out.println("02查询实现");
    }
}
