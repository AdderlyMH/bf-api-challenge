package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utility {

    public static RequestSpecification baseReqSpec;

    public RequestSpecification requestSpecification() throws IOException {

        if (baseReqSpec == null) {

            PrintStream log = new PrintStream(new FileOutputStream("log.txt"));

            baseReqSpec = new RequestSpecBuilder().
                    setBaseUri(getGlobalParam("baseUrl")).
                    addFilter(RequestLoggingFilter.logRequestTo(log)).
                    addFilter(ResponseLoggingFilter.logResponseTo(log)).
                    setContentType(ContentType.JSON).build();

        }

        return baseReqSpec;

    }

    public String getGlobalParam(String globalParam) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/global.properties");
        prop.load(fis);

        return prop.getProperty(globalParam);

    }

    public String getJsonPath(Response response, String field) {

        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);

        return jsonPath.get(field).toString();

    }

}
