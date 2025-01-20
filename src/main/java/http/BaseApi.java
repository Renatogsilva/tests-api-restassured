package http;

import config.PropertyUtil;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApi {

    private final RequestSpecification requestSpecification;

    public BaseApi() {
        this.requestSpecification = RestAssured.given()
                .baseUri(PropertyUtil.getConfig().baseUrl())
                .filter(new AllureRestAssured());
    }

    protected BaseApi setRequestBody(Object object) {
        this.requestSpecification.body(object);
        return this;
    }

    protected void setBasePath(String basePath) {
        this.requestSpecification.basePath(basePath);
    }

    protected BaseApi setContentType(ContentType contentType) {
        this.requestSpecification.contentType(contentType);
        return this;
    }

    protected BaseApi setBasicAuth(String username, String password) {
        this.requestSpecification.auth().preemptive().basic(username, password);
        return this;
    }

    protected void setPathParam(String paramName, Object paramValue) {
        this.requestSpecification.pathParam(paramName, paramValue);
    }

    public BaseApi loggAllRequestData() {
        this.requestSpecification.filter(new RequestLoggingFilter());
        return this;
    }

    public BaseApi loggAllSpecificRequestDetail(LogDetail logDetail) {
        this.requestSpecification.filter(new RequestLoggingFilter(logDetail));
        return this;
    }

    public BaseApi loggAllResponseData() {
        this.requestSpecification.filter(new ResponseLoggingFilter());
        return this;
    }

    public BaseApi loggAllSpecificResponseData(LogDetail logDetail) {
        this.requestSpecification.filter(new ResponseLoggingFilter(logDetail));
        return this;
    }

    protected Response sendRequest(Method methodType) {
        final RequestSpecification when = this.requestSpecification.when();
        return switch (methodType) {
            case GET -> when.get();
            case PUT -> when.put();
            case POST -> when.post();
            case PATCH -> when.patch();
            case DELETE -> when.delete();
            default -> throw new IllegalStateException("Input method type not supported: " + methodType);
        };
    }
}
