package com.zzm.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 抽象基类
 *
 * @author zhengzm
 * @Date 2019/11/22
 **/
@Data
public abstract class BaseModel implements Serializable {
	/**
	 * 主键ID
	 */
	private String id;

	/**
	 * 创建人ID
	 */
	private String creatorId;
	
	/**
	 * 创建人名称
	 */
    private String creatorName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    /**
     * 更新人ID
     */
    private String updaterId;
    
    /**
     * 更新人名称
     */
    private String updaterName;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;

    /**
     * 删除标识
     */
    private Integer isDelete;
}
