package com.huawei.mes.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DBHelper Tester.
 *
 * @author tiandongbo
 * @version 1.0
 * @since <pre>05/06/2021</pre>
 */
public class DBHelperTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getConnection()
     */
    @Test
    public void testGetConnection() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: close(Connection ct, Statement ps, ResultSet rs)
     */
    @Test
    public void testClose() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: executeQuery(String sql, String[] parameters)
     */
    @Test
    public void testExecuteQuery() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: executeUpdate(String sql, String[] parameters)
     */
    @Test
    public void testExecuteUpdate() throws Exception {
        String sql = "insert into T_TEST_CASE_ACTION_RESULT (TRACE_ID, CASE_ID, ACTION_NAME, ACTION_URL, ACTION_RESULT, CREATED_BY)  values (?, ?, ?, ?, ?, ?)";
        String[] parameters = new String[6];
        parameters[0] = "traceId";
        parameters[1] = "traceId";
        parameters[2] = "traceId";
        parameters[3] = "traceId";
        parameters[4] = "traceId";
        parameters[5] = "traceId";
        System.out.println(DBHelper.executeUpdate(sql, parameters));
        System.out.println(DBHelper.executeUpdate("insert into T_TEST_CASE_ACTION_RESULT (TRACE_ID, CREATED_BY)  values ('tiandongbo0', 'jmeter01')", null));

    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here... 
    }


} 
