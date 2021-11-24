package userArray;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SerialDeserialArray {
    @Test
    public void getResponseDetails(){
        UserInfo userInfo= new UserInfo();
        List<UserInfo> list= new ArrayList<>();
        userInfo.setId(206);
        userInfo.setUsername("gayathri13");
        userInfo.setFirstName("Gayathri");
        userInfo.setLastName("S");
        userInfo.setEmail("gayathri.gmail.com");
        userInfo.setPassword("gayathri");
        userInfo.setPhone("23423543453");
        userInfo.setUserStatus(115);
        list.add(userInfo);

        userInfo=new UserInfo();
        userInfo.setId(205);
        userInfo.setUsername("gayathri13");
        userInfo.setFirstName("Gayathri");
        userInfo.setLastName("S");
        userInfo.setEmail("gayathri.gmail.com");
        userInfo.setPassword("gayathri");
        userInfo.setPhone("23423543453");
        userInfo.setUserStatus(115);

        list.add(userInfo);

        // To check the status code
        Response response=
                given().contentType(ContentType.JSON).
                        body(list).
                        log().body().
                when().
                        post("https://petstore.swagger.io/v2/user/createWithArray").
                then().
                        assertThat().statusCode(200).and().
                        extract().response();


        // To covert the response into java object
        ResponseUserArray responseUserArray =
                given().contentType(ContentType.JSON).
                        body(list).
                when().
                        post("https://petstore.swagger.io/v2/user/createWithArray").
                        as(ResponseUserArray.class);


        System.out.println(responseUserArray.getCode());
       Assert.assertEquals(responseUserArray.getCode(),200);


       Assert.assertEquals(responseUserArray.getMessage(),"ok");

        System.out.println(responseUserArray);
    }
}
