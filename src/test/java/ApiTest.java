
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ApiTest {

    @Test
    void apiGetTest(){
        baseURI = "http://localhost:3000/";

        given().
                param("name", "sonoo").
                get("/employee").
        then().
                statusCode(200).log().all();

    }

    @DataProvider(name = "newEmployees")
    public Object[][] newEmployees() {
        return new Object[][]{
                {"Kate", "200000","true", 5},
        };
    }

    @Test(dataProvider = "newEmployees")
    void apiPostTest(String name, String salary, String married, Integer id){

        JSONObject request = new JSONObject();

        request.put("name",name);
        request.put("salary",salary);
        request.put("married",married);
        request.put("married",id);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toString()).
        when().
                post("/employee").
        then().
                statusCode(201).
                log().all();

    }

    @Test()
    void apiPutTest(){

        JSONObject request = new JSONObject();

        request.put("name","Iryna");
        request.put("salary","3400");
        request.put("married","false");

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toString()).
        when().
                put("/employee/2").
        then().
                statusCode(200).
                log().all();

    }

    @DataProvider(name = "deleteEmployee")
    public Object[][] deleteEmployee() {
        return new Object[][]{
                {4}
        };
    }

    @Test(dataProvider = "deleteEmployee")
    void apiDeleteTest( int userId){

        baseURI = "http://localhost:3000/";

        when().
                delete("/employee/" + userId).
        then().
                statusCode(200);

    }

}
