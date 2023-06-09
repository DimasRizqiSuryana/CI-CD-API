package starter.stepfeiniton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.User.Delete;
import starter.User.Get;
import starter.User.Post;
import starter.User.Put;

public class UserSteps {
    @Steps
    Get get;

    @Steps
    Delete delete;

    @Steps
    Post post;

    @Steps
    Put put;
    @Given("I set GET api endpoints")
    public void setGetApiEndpoints(){
        get.setGetEndpoints();
    }

    @When("I send GET HTTP request")
    public void sendGetHttpRequest(){
        get.getHTTPrequest();
    }

    @Then("I recive valid HTTP response code 200")
    public void reciveValidHttpResponse(){
        get.HTTPresponse200();
    }

    @And("I recive valid data for detail user")
    public void reciveValidDataForDetailUser(){
        get.validData();
    }

    @Given("I set POST api endpoints")
    public void setPostApiEndpoints(){
        post.setPostApiEndpoint();
    }

    @When("I send POST HTTP request")
    public void sendPostHttpRequest(){
        post.sendPostHTTPRequest();
    }

    @Then("I receive valid HTTP response code 201")
    public void receiveValidHttp201(){
        post.receiveHttpResponseCode201();

    }
    @And("I receive valid data for new user")
    public void validateDataNewUser(){
        post.validateDatanewUser();

    }

    @Given("I set PUT api endpoints")
    public void setPutApiEndpoints(){
        put.setPutApiEndpoints();
    }
    @When("I send PUT HTTP request")
    public void sendPutHttpRequest(){
        put.sendPutHttpRequest();
    }

    @And("I receive valid data for update user")
    public void validateUpdateUser(){
        put.validateUpdateUser();

    }

    @Given("I set DELETE api endpoints")
    public void setDeleteApiEndpoints(){
        delete.setDeleteApiEndpoints();
    }
    @When("I send DELETE HTTP request")
    public void sendDeleteApiEndpoints(){
        delete.sendDeleteHttpRequest();
    }
    @Then("I receive valid HTTP response code 204")
    public void validateHttpResponseCode204(){
        delete.validateHttpResponse204();
    }
}
