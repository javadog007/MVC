package mengluo.mvc.upload;

import javax.servlet.http.Part;

/**
 * 支持文件上传的接口
 */
public interface Uploadable {
	 /** 
     * 设置文件名 
     * @param filenames 文件名的数组 
     */  
    public void setFilenames(String[] filenames);  
      
    /** 
     * 设置上传的附件 
     * @param parts 附件的数组 
     */  
    public void setParts(Part[] parts);  
}
