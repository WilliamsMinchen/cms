package com.xzjie.et.wechat.dao;

import com.xzjie.et.wechat.model.WxGroupFollow;
import com.xzjie.mybatis.core.dao.BaseMapper;

import java.util.List;

public interface WxGroupFollowMapper extends BaseMapper<WxGroupFollow,Long> {
    /*int deleteByPrimaryKey(Long id);

    int insert(WxGroupFollow record);

    int insertSelective(WxGroupFollow record);

    WxGroupFollow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WxGroupFollow record);*/

    int batchInsert(List<WxGroupFollow> list);
}