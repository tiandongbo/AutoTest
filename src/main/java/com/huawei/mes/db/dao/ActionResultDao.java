package com.huawei.mes.db.dao;

import com.huawei.mes.db.dao.entity.ActionResultDO;

public interface ActionResultDao {
    int deleteByPrimaryKey(Object resultId);

    int insert(ActionResultDO record);

    int insertSelective(ActionResultDO record);

    ActionResultDO selectByPrimaryKey(Object resultId);

    int updateByPrimaryKeySelective(ActionResultDO record);

    int updateByPrimaryKey(ActionResultDO record);
}