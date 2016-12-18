# result-util
[![Build Status](https://travis-ci.org/neoremind/result-util.svg?branch=master)](https://travis-ci.org/neoremind/result-util)
[![Coverage Status](https://coveralls.io/repos/github/neoremind/result-util/badge.svg?branch=master)](https://coveralls.io/github/neoremind/result-util?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.neoremind/result-util/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.neoremind/result-util)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)

Result utility for Java programmer

##Prerequisite

In order to use `result-util` in your project, simply add the following dependency. (Example is for maven pom.xml)
```
<dependency>
    <groupId>net.neoremind</groupId>
    <artifactId>result-util</artifactId>
    <version>1.0.0</version>
</dependency>
```
Check out the lastest version on Maven Central.

By default, org.slf4j:slf4j-api:jar:1.7.7 and org.slf4j:slf4j-log4j12:jar:1.7.7 are used as logger.

You can switch to other slf4j implementation such as logback and exclude log4j like below:
```
<dependency>
    <groupId>net.neoremind</groupId>
    <artifactId>result-util</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

## Usage
###1. Define result enum

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

###2. Create XML resource file

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

###3. Start to use :-)
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

##Dependencies
```
[INFO] +- org.slf4j:slf4j-api:jar:1.7.7:compile
[INFO] +- org.slf4j:slf4j-log4j12:jar:1.7.7:provided
[INFO] |  \- log4j:log4j:jar:1.2.17:provided
[INFO] +- dom4j:dom4j:jar:1.6.1:compile
[INFO] |  \- xml-apis:xml-apis:jar:1.0.b2:compile
[INFO] +- jaxen:jaxen:jar:1.1.1:compile
[INFO] |  +- jdom:jdom:jar:1.0:compile
[INFO] |  +- xerces:xercesImpl:jar:2.6.2:compile
[INFO] |  \- xom:xom:jar:1.0:compile
[INFO] |     +- xerces:xmlParserAPIs:jar:2.6.2:compile
[INFO] |     +- xalan:xalan:jar:2.6.0:compile
[INFO] |     \- com.ibm.icu:icu4j:jar:2.6.1:compile
```