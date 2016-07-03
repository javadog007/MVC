package mengluo.mvc.util;

public interface TypeConverter {
	 public Object convert(Class<?> elemType, String value) throws Exception;  
}
