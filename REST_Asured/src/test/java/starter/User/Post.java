package starter.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Post {
    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set POST endpoints")
    public String setPostApiEndpoint(){
        return url + "posts"; }

    @Step("I send POST HTTP request")
    public void sendPostHTTPRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("userid",10);
        requestBody.put("title","DimasRS");
        requestBody.put("body","Hallo nama saya Dimas");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }

    @Step("I receive valid HTTP response code 201")
    public void receiveHttpResponseCode201(){

        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid data for new user")
    public void validateDatanewUser(){
        restAssuredThat(response -> response.body("'userid'", equalTo(10)));
        restAssuredThat(response -> response.body("'title'", equalTo("DimasRS")));
        restAssuredThat(response -> response.body("'body'", equalTo("Hallo nama saya Dimas")));
    }

}
