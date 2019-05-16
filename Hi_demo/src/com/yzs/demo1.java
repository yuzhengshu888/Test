package com.yzs;

import java.util.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.entity.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class demo1 {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public void demo1() {
    }

    //初始化hibernate对象
    public void init() {
        //创建配置对象
        Configuration config = new Configuration().configure();
        //创建服务注册对象
        //  ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();（使用这种方法会报错，unkonw Entity 。。。。）
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象

        sessionFactory = config.buildSessionFactory(serviceRegistry);
        //创建会话对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
    }

    public void addclass(int class_id ,String class_name) {
        //在class表中增加班级 （class_id=3 ，class_name=软件三班）
        ClassTableEntity class01 = new ClassTableEntity();
        class01.setClassId(class_id);
        class01.setClassName(class_name);
        session.save(class01);
    }

    //date的格式转换
    public static Date dateString2Date(String date_str) {
        try {
            Calendar cal = Calendar.getInstance();
            java.sql.Timestamp timestampnow = new java.sql.Timestamp(cal.getTimeInMillis());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            ParsePosition pos = new ParsePosition(0);
            java.util.Date utilDate = formatter.parse(date_str, pos);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            return sqlDate;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void addstudent(int student_id,String student_name,String student_sex,int class_id,String student_birth) {
        //在student表中增加学生
        //birth的格式为2016-1-4
        StudentTableEntity student = new StudentTableEntity();
        student.setStudentId(student_id);
        student.setStudnetName(student_name);
        student.setStudentSex(student_sex);
        student.setClassId(class_id);
        Date date = dateString2Date(student_birth);
        student.setStudentBirth((java.sql.Date) date);

//        //在student表中增加学生
//        StudentTableEntity s2 = new StudentTableEntity();
//        s2.setStudentId(1002);
//        s2.setStudnetName("李四");
//        s2.setStudentSex("男");
//        s2.setClassId(2);
//        s2.setStudentBirth((java.sql.Date) date);
//        session.save(s2);

        session.save(student);

    }

    public void deletestudent(int student_id) {
        //根据主键student_id删除学生
        StudentTableEntity student = new StudentTableEntity();
        student.setStudentId(student_id);
        session.delete(student);
    }

    public void deleteclass(int class_id) {
        //根据主键class_id删除班级
        ClassTableEntity class01 = new ClassTableEntity();
        class01.setClassId(class_id);
        session.delete(class01);

    }

    //测试
    public void testSaveUser() {
        UserEntity user = new UserEntity();
        user.setPassword(49);
        user.setUsername(456);
        session.save(user);//保存对象进入数据库
    }

    //关闭所有连接
    public void destory() {
        //提交事务
        transaction.commit();
        //关闭session
        session.close();
        //关闭sessionFactory
        sessionFactory.close();
    }

}
