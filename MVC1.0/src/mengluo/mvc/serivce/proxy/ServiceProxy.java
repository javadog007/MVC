package mengluo.mvc.serivce.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import mengluo.mvc.exception.DbSessionException;
import mengluo.mvc.serivce.db.DbSession;
import mengluo.mvc.serivce.db.DbSessionFactory;
/**
 * 业务的代理对象
 */
public class ServiceProxy implements InvocationHandler{

    private Object target;  
     
    public ServiceProxy(Object target) {  
        this.target = target;  
    }  
      
    public static Object getProxyInstance(Object target) {  
        Class<?> clazz = target.getClass();  
          
        return Proxy.newProxyInstance(clazz.getClassLoader(),   
                clazz.getInterfaces(), new ServiceProxy(target));  
    }  
      
    @Override  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object retValue = null;  
        DbSession session = DbSessionFactory.openSession();  
        boolean isTxNeeded = !method.getName().startsWith("get");  
        try {  
            if(isTxNeeded) session.beginTx();  
            retValue = method.invoke(target, args);  
            if(isTxNeeded) session.commitTx();  
        }  
        catch(DbSessionException ex) {  
            ex.printStackTrace();  
            if(isTxNeeded) session.rollbackTx();  
        }  
        finally {  
            DbSessionFactory.closeSession();  
        }  
        return retValue;  
    }  

}
