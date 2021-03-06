package com.dianrong.common.uniauth.server.data.mapper;

import com.dianrong.common.uniauth.server.data.entity.GrpTagExample;
import com.dianrong.common.uniauth.server.data.entity.GrpTagKey;
import java.util.List;

import com.dianrong.common.uniauth.server.support.audit.MapperAudit;
import org.apache.ibatis.annotations.Param;

@MapperAudit
public interface GrpTagMapper {

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * grp_tag
   *
   * @mbggenerated Mon Apr 11 13:45:44 CST 2016
   */
  int countByExample(GrpTagExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * grp_tag
   *
   * @mbggenerated Mon Apr 11 13:45:44 CST 2016
   */
  int deleteByExample(GrpTagExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * grp_tag
   *
   * @mbggenerated Mon Apr 11 13:45:44 CST 2016
   */
  int deleteByPrimaryKey(GrpTagKey key);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * grp_tag
   *
   * @mbggenerated Mon Apr 11 13:45:44 CST 2016
   */
  int insert(GrpTagKey record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * grp_tag
   *
   * @mbggenerated Mon Apr 11 13:45:44 CST 2016
   */
  int insertSelective(GrpTagKey record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * grp_tag
   *
   * @mbggenerated Mon Apr 11 13:45:44 CST 2016
   */
  List<GrpTagKey> selectByExample(GrpTagExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * grp_tag
   *
   * @mbggenerated Mon Apr 11 13:45:44 CST 2016
   */
  int updateByExampleSelective(@Param("record") GrpTagKey record,
      @Param("example") GrpTagExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * grp_tag
   *
   * @mbggenerated Mon Apr 11 13:45:44 CST 2016
   */
  int updateByExample(@Param("record") GrpTagKey record, @Param("example") GrpTagExample example);

  /**
   * batch insert GrpTagKey.
   */
  int batchInsert(@Param("infoes") List<GrpTagKey> infoes);
}
