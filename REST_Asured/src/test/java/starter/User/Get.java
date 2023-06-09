package starter.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
public class Get {
    protected static String url = "https://jsonplaceholder.typicode.com/";
    @Step("I set GET endpoints")
    public String setGetEndpoints(){
        return url + "posts/1";

    }
    @Step("I send GET HTTP request")
    public void getHTTPrequest(){
        SerenityRest.given()
                .when()
                .get(setGetEndpoints());

    }
    @Step("I receive valid data for detail user")
    public void validData(){
        restAssuredThat(response -> response.body("userId", equalTo(1)));
        restAssuredThat(response -> response.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));

    }

    @Step("I receive valid HTTP response code 200")
    public void HTTPresponse200(){
        restAssuredThat(response -> response.statusCode(200));
    }
}
