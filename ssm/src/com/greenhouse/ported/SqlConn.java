package com.greenhouse.ported;

import java.sql.*;

public class SqlConn {
    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/leon?useSSL=false";
        String username = "root";
        String password = "1741";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection setConn() {
        return getConn();
    }

    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int insert(Sensor sensor) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into sensor (temp,humi,illu,date) values(?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setFloat(1, sensor.getTemp());
            pstmt.setFloat(2, sensor.getHumi());
            pstmt.setInt(3, sensor.getIllu());
            pstmt.setTimestamp(4, sensor.getTime());
            i = pstmt.executeUpdate();
            SqlConn.close(conn, pstmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
