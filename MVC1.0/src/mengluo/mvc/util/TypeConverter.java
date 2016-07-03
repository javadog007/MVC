package mengluo.mvc.util;
/**
 * 转换工具接口
 */
public interface TypeConverter {
	 public Object convert(Class<?> elemType, String value) throws Exception;  
}
