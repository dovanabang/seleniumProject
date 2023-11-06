package TestCases;

import Pages.SignInPage;
import dovanbang.com.testLogin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class SignInTest extends testLogin {
    private WebDriver driver;

    private SignInPage signInPage;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
    }

    @Test
    public void signInPage() throws Exception {
        signInPage = new SignInPage(driver);
        signInPage.SignIn("mngr533163", "arUhegU");
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
