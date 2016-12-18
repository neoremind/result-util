/**
 * 
 */
package net.neoremind.resultutil;

import net.neoremind.resultutil.result.ResultCode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhangxu
 */
public class ResultCodeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void resultCode() {
        ResultCode code = ResultCode.DAO_FAILURE;
        Assert.assertEquals("DAO_FAILURE", code.getName());
        Assert.assertEquals(4, code.getCode());
        Assert.assertEquals("Data access failure", code.getMessage().getMessage());
        code = ResultCode.SUCCESS;
        Assert.assertEquals("SUCCESS", code.getName());
        Assert.assertEquals(0, code.getCode());
        Assert.assertEquals("OK", code.getMessage().getMessage());
    }

}
