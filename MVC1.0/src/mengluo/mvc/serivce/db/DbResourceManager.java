package mengluo.mvc.serivce.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * 数据库资源管理
 */
public class DbResourceManager {
	
	private static final String JDBC_DRV = "com.mysql.jdbc.Driver";  
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mvc";  
    private static final String JDBC_UID = "root";  
    private static final String JDBC_PWD = "root";
    
    private static Driver driver = null;  
    private static Properties info = new Properties();
    
    private DbResourceManager() {  
        throw new AssertionError();  
    }
    
    static {      
        try {  
            loadDriver();   // 通过静态代码块加载数据库驱动  
            info.setProperty("user", JDBC_UID);  
            info.setProperty("password", JDBC_PWD);  
        }  
        catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
      
    public static void setDriver(Driver _driver) {  
        driver = _driver;  
    }  
      
    // 加载驱动程序  
    private static void loadDriver() throws Exception {  
        driver = (Driver) Class.forName(JDBC_DRV).newInstance();  
        DriverManager.registerDriver(driver);  
    }  
      
    /** 
     * 打开连接 
     * @return 连接对象 
     * @throws Exception 无法加载驱动或无法建立连接时将抛出异常 
     */  
    public static Connection getConnection() throws Exception {  
        if(driver == null) {  
            loadDriver();  
        }  
        return driver.connect(JDBC_URL, info);  
    }  
      
    /** 
     * 关闭游标 
     */  
    public static void close(ResultSet rs) {  
        try {  
            if(rs != null && !rs.isClosed()) {  
                rs.close();  
            }  
        }  
        catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 关闭语句 
     */  
    public static void close(Statement stmt) throws SQLException {  
        try {  
            if(stmt != null && !stmt.isClosed()) {  
                stmt.close();  
            }  
        }  
        catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 关闭连接 
     */  
    public static void close(Connection con) {  
        try {  
            if(con != null && !con.isClosed()) {  
                con.close();  
            }  
        }  
        catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 注销驱动 
     * @throws SQLException 
     */  
    public static void unloadDriver() throws SQLException {  
        if(driver != null) {  
            DriverManager.deregisterDriver(driver);  
            driver = null;  
        }  
    }  
}
