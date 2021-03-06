package com.zysj.label_data.utils;/**
 * Created by 尚先生 on 2019/9/20.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 尚先生
 * @date 2019/9/20 17:17
 */

public class PostgreSQLUtils {
    private static final String DATABASE_NAME = "label_data"; // 数据库名称
    private static final String USER_NAME = "postgres"; // 用户名
    private static final String PASS_WORD = "Zysj@123";     // 密码
    private static Connection c = null; 				// 连接对象
    private static Statement stmt = null;				// SQL语句执行


    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            c = DriverManager
                    .getConnection("jdbc:postgresql://47.100.123.80:5432/"+DATABASE_NAME,USER_NAME,PASS_WORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建表
     * @param sql 传入创建表的sql语句
     * @return
     */
    public static boolean createTable(String sql) {
        c = PostgreSQLUtils.getConnection();
        System.out.println("创建成功");
        boolean flag = false;
        try {
            stmt = c.createStatement();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        }
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        }
        closeConnection();
        return flag;

    }


    /**
     * 保存信息
     * @param sql
     * @return
     */
    public static boolean save(String sql) {
//		Connection connection = PostgreSQLUtils.getConnection();
//		String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)" +
//				"VALUES (1, 'Paul', 32, 'California', 20000.00 );";
//		PostgreSQLUtils.save(sql);
        boolean flag = false;
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            flag = true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            flag = false;
        }
        closeConnection();
        return flag;
    }


    /**
     * 删除操作
     * @param sql
     * @return
     */
    public static boolean delete(String sql) {
//		Connection connection = PostgreSQLUtils.getConnection();
//		String sql = "DELETE from COMPANY where ID=2;";
//		PostgreSQLUtils.delete(sql);
        boolean flag = false;
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            flag = true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            flag = false;
        }
        closeConnection();
        return flag;
    }



    /**
     * 更新操作
     * @param sql
     * @return
     */
    public static boolean update(String sql) {
        //Connection connection = PostgreSQLUtils.getConnection();
        //String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
        //PostgreSQLUtils.update(sql);
        boolean flag = false;
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            flag = true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            flag = false;
        }
        closeConnection();
        return flag;
    }




}
