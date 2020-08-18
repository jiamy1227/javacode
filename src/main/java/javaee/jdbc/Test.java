package javaee.jdbc;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useUnicode=true&characterEncoding=utf-8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "123456";

        String sql = "SELECT id, grade, name, gender,score FROM students WHERE name=?";
        String name = "小白";
        ResultSet rs = null;
        PreparedStatement ps;
// 获取连接:
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            ps = conn.prepareStatement(sql);
            ps.setObject(1, "小明"); // 注意：索引从1开始
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name")+"分数："+rs.getInt("score"));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
