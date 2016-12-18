# result-util
Result utility for Java programmer

## Usage
1. Define result enum
For example, under `com.myproject` package.
```
import net.neoremind.resultutil.result.ResultCode;
import net.neoremind.resultutil.result.ResultCodeMessage;
import net.neoremind.resultutil.result.ResultCodeUtil;

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
    DAO_FAILURE;

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
```

2. Create XML resource file

**The XML file MUST be in the same class path and named the same filename as the `Enum` defined above**

For example, create a xml file named `SampleResultCode.xml` under `com/myproject` path.

```
<?xml version="1.0" encoding="UTF-8"?>
<resource-bundle name="ResultCode">
    <message id="HTTP_SUCCESS">
        <data>Operation is successful</data>
        <code>10001</code>
    </message>
    <message id="HTTP_FAILED">
        <data>Operation failed with HTTP CODE = {0}</data>
        <code>10002</code>
    </message>
    <message id="SERVICE_FAILURE">
        <code>10003</code>
        <data>Service failure</data>
    </message>
    <message id="DAO_FAILURE">
        <code>10004</code>
        <data>DAO failure</data>
    </message>
</resource-bundle>
```

3. Application
```
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
```