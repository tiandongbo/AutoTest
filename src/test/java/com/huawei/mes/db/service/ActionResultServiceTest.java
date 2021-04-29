package com.huawei.mes.db.service;

import com.huawei.mes.common.ResultVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ActionResultService Tester.
 *
 * @author tiandongbo
 * @version 1.0
 * @since <pre>04/29/2021</pre>
 */
public class ActionResultServiceTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insert(String traceId, String actionName, String caseId, String acionUrl, String createdBy, String actionResult)
     */
    @Test
    public void testInsert() throws Exception {
        ActionResultService service = new ActionResultService();
        ResultVO resultVO = service.insert("t1111111111111111", "getLotInfo", "T01", "/lotinfo", "jmeter", "Pass");
        System.out.println("resCode :" + resultVO.getResCode());
        System.out.println("resMsg :" + resultVO.getResMsg());

    }


} 
