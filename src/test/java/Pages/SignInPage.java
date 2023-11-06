package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    public WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userID = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");

    private By password = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");

    private By login = By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]");

    public Managerpage SignIn(String userIDValue, String passWordValue) {
        driver.findElement(userID).sendKeys(userIDValue);
        driver.findElement(password).sendKeys(passWordValue);
        driver.findElement(login).click();
        return new Managerpage(driver);
    }
}
