package com.dianrong.common.uniauth.client.custom.model;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.Assert;

/**
 * 当前登陆用户的所有域下的权限集合的信息
 * @author wanglin
 */
public class AllDomainUserExtInfo implements Serializable {
	private static final long serialVersionUID = 8347558918889027136L;
	// Map<DomainCode, userExtInfo>
	private ConcurrentHashMap<String, SingleDomainUserExtInfo> userExtInfoMap = new ConcurrentHashMap<>();
	
	/**
	 * get userExtInfo by domainCode
	 * @param domainCode not null
	 * @return UserDetails in domain[domainCode]
	 * @throws IllegalArgumentException if the domainCode is null
	 */
	public SingleDomainUserExtInfo getUserDetail(String domainCode) {
	    Assert.notNull(domainCode);
	    return userExtInfoMap.get(domainCode);
	}
	
	   /**
     * get userExtInfo by domainCode
     * @param domainCode not null
     * @return UserDetails in domain[domainCode]
     * @throws IllegalArgumentException if the domainCode or userDetails is null
     */
    public void addUserDetail(String domainCode, SingleDomainUserExtInfo userDetails) {
        Assert.notNull(domainCode);
        Assert.notNull(userDetails);
        userExtInfoMap.put(domainCode, userDetails);
    }
    
    /**
     * get userExtInfo by domainCode
     * @param domainCode not null
     * @return UserDetails in domain[domainCode]
     * @throws IllegalArgumentException if the domainCode or userDetails is null
     */
    public SingleDomainUserExtInfo addUserDetailIfAbsent(String domainCode, SingleDomainUserExtInfo userDetails) {
        Assert.notNull(domainCode);
        Assert.notNull(userDetails);
       return userExtInfoMap.putIfAbsent(domainCode, userDetails);
    }
    
    public SingleDomainUserExtInfo getOneSingleDomainUserExtInfo() {
    	for(String code : userExtInfoMap.keySet()){
    		return userExtInfoMap.get(code);
    	}
    	throw new RuntimeException("userExtInfoMap is empty");
    }
}
