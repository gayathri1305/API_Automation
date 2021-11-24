package singleuser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class SerialDeserialTest {
    @Test
    public void getResponseDetails(){
        UserInfo userInfo= new UserInfo();

        userInfo.setId(202);
        userInfo.setUsername("gayathri13");
        userInfo.setFirstName("Gayathri");
        userInfo.setLastName("S");
        userInfo.setEmail("gayathri.gmail.com");
        userInfo.setPassword("gayathri");
        userInfo.setPhone("23423543453");
        userInfo.setUserStatus(112);
        // To check the status code
        Response response=
                given().contentType(ContentType.JSON).
                        body(userInfo).
                        log().body().
                when().
                        post("https://petstore.swagger.io/v2/user").
                then().
                        assertThat().statusCode(200).and().
                        extract().response();


        // To covert the response into java object
        ResponseUserDetail responseUserDetail=
                given().contentType(ContentType.JSON).
                        body(userInfo).
                when().
                        post("https://petstore.swagger.io/v2/user").
                        as(ResponseUserDetail.class);

        //Check the code value and id==message
        Assert.assertEquals(responseUserDetail.getCode(),"200");
        Assert.assertEquals(userInfo.getId(),Integer.parseInt(responseUserDetail.getMessage()));
        System.out.println(responseUserDetail);
    }
}
