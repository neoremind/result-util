package net.neoremind.resultutil;

import net.neoremind.resultutil.result.ResultCode;
import net.neoremind.resultutil.result.ResultCodeMessage;
import net.neoremind.resultutil.result.ResultCodeUtil;

/**
 * SampleResultCode
 *
 * @author zhangxu
 */
public enum SampleResultCode implements ResultCode {

    /**
     * HTTP OK
     */
    HTTP_SUCCESS,

    /**
     * HTTP Failed
     */
    HTTP_FAILED,

    /**
     * Service failure
     */
    SERVICE_FAILURE,

    /**
     * Data access failure
     */
    DAO_FAILURE,

    /**
     * NOT EXIST IN RESOURCE!
     */
    UNKOWN_FAILURE;

    private final ResultCodeUtil util = new ResultCodeUtil(this);

    public String getName() {
        return util.getName();
    }

    public ResultCodeMessage getMessage() {
        return util.getMessage();
    }

    public ResultCodeMessage getMessage(String args) {
        return util.getMessage(args);
    }

    public int getCode() {
        return util.getCode();
    }

}
