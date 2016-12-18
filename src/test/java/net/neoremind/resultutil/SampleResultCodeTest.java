package net.neoremind.resultutil;

import net.neoremind.resultutil.result.ResultCode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import net.neoremind.resultutil.result.ResultCodeRuntimeException;

/**
 * @author zhangxu
 */
public class SampleResultCodeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void resultCode() {
        ResultCode code = SampleResultCode.HTTP_SUCCESS;
        Assert.assertEquals("HTTP_SUCCESS", code.getName());
        Assert.assertEquals(10001, code.getCode());
        Assert.assertEquals("Operation is successful", code.getMessage().getMessage());
    }

    @Test
    public void resultCode2() {
        SampleResultCode code = SampleResultCode.HTTP_FAILED;
        Assert.assertEquals("HTTP_FAILED", code.getName());
        Assert.assertEquals(10002, code.getCode());
        Assert.assertEquals("Operation failed with HTTP CODE = THIS IS THE CAUSE", code.getMessage("THIS IS THE CAUSE").getMessage());
        Assert.assertEquals("Operation failed with HTTP CODE = THIS IS THE CAUSE", SampleResultCode.HTTP_FAILED.getMessage("THIS IS THE CAUSE").getMessage());
    }

    @Test
    public void resultCode3() {
        ResultCode code = SampleResultCode.SERVICE_FAILURE;
        Assert.assertEquals("SERVICE_FAILURE", code.getName());
        Assert.assertEquals(10003, code.getCode());
        Assert.assertEquals("", code.getMessage().getMessage());
    }

    @Test
    public void resultCode4() {
        ResultCode code = SampleResultCode.DAO_FAILURE;
        Assert.assertEquals("DAO_FAILURE", code.getName());
        Assert.assertEquals(0, code.getCode());
        Assert.assertEquals("DAO failure", code.getMessage().getMessage());
    }

    @Test(expected = ResultCodeRuntimeException.class)
    public void resultCode5() {
        ResultCode code = SampleResultCode.UNKOWN_FAILURE;
        Assert.assertEquals("UNKOWN_FAILURE", code.getName());

        // not defined throw exception
        Assert.assertEquals(0, code.getCode());
    }

    @Test
    public void resultCode6() {
        ResultCode code = SampleResultCode.UNKOWN_FAILURE;
        Assert.assertEquals("UNKOWN_FAILURE", code.getName());

        // not defined return enum name
        Assert.assertEquals("UNKOWN_FAILURE", code.getMessage().getMessage());
    }

}
