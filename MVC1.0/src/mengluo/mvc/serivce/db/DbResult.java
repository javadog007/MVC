package mengluo.mvc.serivce.db;

import java.io.Serializable;

/**
 * 数据库操作的结果
 */
public class DbResult {
	private int affectedRows;       // 受影响的行数  
    private Serializable generatedKey;  // 生成的主键  
  
    public DbResult(int affectedRows, Serializable generatedKey) {  
        this.affectedRows = affectedRows;  
        this.generatedKey = generatedKey;  
    }  
  
    public int getAffectedRows() {  
        return affectedRows;  
    }  
  
    public Serializable getGeneratedKey() {  
        return generatedKey;  
    }  
}
