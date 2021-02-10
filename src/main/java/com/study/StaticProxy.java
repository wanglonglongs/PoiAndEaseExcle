package com.study;

import java.util.Date;

/**
 * @ClassName StaticProxy
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/10
 * @Version V1.0
 **/
public class StaticProxy implements StaticProxyService {
    //同一接口
    private StaticProxyService staticProxyService;
    //获取带参构造
    public StaticProxy(StaticProxyService staticProxyService) {
        this.staticProxyService = staticProxyService;
    }

    //增强目标类（例如：日志）
    public void query(Integer stuId) {
        EntityLog entityLog = new EntityLog();
        entityLog.setStuId(stuId);
        entityLog.setXingxi("查询信息");
        entityLog.setRelust("成功日志结果");
        entityLog.setCreateDate(new Date());
        //当有多个目标类，可以通过类名来区分 也可以通过判断类型 instanceof
        entityLog.setType(staticProxyService.getClass().toString());
        //也可以直接判断类型
        if (staticProxyService instanceof ServiceImpl01){
            entityLog.setType("01");
        }
        if (staticProxyService instanceof ServiceImpl02){
            entityLog.setType("02");
        }
        staticProxyService.query(stuId);
        System.out.println("日志信息" + entityLog);
    }
}
