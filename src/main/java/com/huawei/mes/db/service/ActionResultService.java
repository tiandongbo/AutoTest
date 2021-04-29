package com.huawei.mes.db.service;

import com.huawei.mes.common.ResultVO;
import com.huawei.mes.db.dao.ActionResultDao;
import com.huawei.mes.db.dao.entity.ActionResultDO;
import com.huawei.mes.util.db.SqlSessionFactoryUtil;

/**
 * ClassName ActionResultService
 * Description
 * Create by tiandongbo 00350982
 * Date 2021/4/27 21:46
 */
public class ActionResultService {
    public ResultVO insert(String traceId, String actionName, String caseId, String acionUrl, String createdBy, String actionResult) {
        ResultVO resultVO = new ResultVO();
        ActionResultDO actionResultDO = new ActionResultDO();
        actionResultDO.setTraceId(traceId);
        actionResultDO.setActionName(actionName);
        actionResultDO.setCaseId(caseId);
        actionResultDO.setActionUrl(acionUrl);
        actionResultDO.setCreatedBy(createdBy);
        actionResultDO.setActionResult(actionResult);
        ActionResultDao actionResultImp = SqlSessionFactoryUtil.getTestMapper(ActionResultDao.class);
        try {
            int res = actionResultImp.insert(actionResultDO);
            if (res == 0) {
                resultVO.setResCode(0);
                resultVO.setResMsg("0 row date inserted");
            } else {
                resultVO.setResCode(1);
                resultVO.setResMsg("action result inserted successfully");
            }
        } catch (Exception e) {
            resultVO.setResCode(0);
            resultVO.setResMsg(e.getMessage());
        }
        return resultVO;
    }
}
