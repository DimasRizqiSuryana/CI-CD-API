package starter.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Put {
    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set PUT api endpoints")
    public String setPutApiEndpoints(){
        return url + "posts/1";
    }
    @Step("I send PUT HTTP request")
    public void sendPutHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("title","my name is DimasSopo");
        requestBody.put("body","Ini sudah diubah");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).put(setPutApiEndpoints());
    }

    @Step("I receive valid data for update user")
    public void validateUpdateUser(){
        restAssuredThat(response -> response.body("'title'", Matchers.equalTo("my name is DimasSopo")));
        restAssuredThat(response -> response.body("'body'", Matchers.equalTo("Ini sudah diubah")));
    }
}
