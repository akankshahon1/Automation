package steps;
import helper.LoginAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class LoginSteps {
    String baseUrl = "https://wdp-service-enterprise.wescodevops.com/";
    String loginPath;
    @Steps
    LoginAPI loginAPI;

    @Given("the login API")
    public void theLoginAPI(){
        loginPath="api/v1/wesco/auth/token";
        System.out.println("Login API");
    }
    @When("user credentials are provided to login API")
    public void userCredentialsAreProvidedToLoginAPI(){
        String basePath = baseUrl+loginPath;
        loginAPI.postLoginAPI(basePath,"pradeep.baskaran@wescodist.com","Login@123");

        System.out.println("User Credentials are provided to login API");
    }
    @Then("access token is extracted from the response")
    public void accessTokenIsExtractedFromTheResponse(){
        System.out.println("Access token is extracted from the response");
    }
}
