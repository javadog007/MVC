package mengluo.mvc.serivce.db;
/**
 * 数据库会话工厂
 */
public class DbSessionFactory {
	
  private static final ThreadLocal<DbSession> threadLocal = new ThreadLocal<DbSession>();  
  private DbSessionFactory() {  
        throw new AssertionError();  
    }  
      
    /** 
     * 打开会话 
     * @return DbSession对象 
     */  
    public static DbSession openSession() {  
        DbSession session = threadLocal.get();  
          
        if(session == null) {  
            session = new DbSession();  
            threadLocal.set(session);  
        }  
          
        session.open();  
          
        return session;  
    }  
      
    /** 
     * 关闭会话 
     */  
    public static void closeSession() {  
        DbSession session = threadLocal.get();  
        threadLocal.set(null);  
          
        if(session != null) {  
            session.close();  
        }  
    } 
}
