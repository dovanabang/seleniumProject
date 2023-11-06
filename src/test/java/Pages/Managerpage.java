package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Managerpage {
    public WebDriver driver;

    public Managerpage(WebDriver driver) {
        this.driver = driver;
    }

    private String urlCurrent = "Managerhomepage";
    private By buttonCustomer = By.xpath("/html/body/div[3]/div/ul/li[2]/a");

    private By buttonNewAccount = By.xpath("/html/body/div[3]/div/ul/li[5]/a");

    public boolean checkCurrentURLIsManagerhomepage() {

        return driver.getCurrentUrl().contains(urlCurrent);
    }

    public NewCustomerPage openNewCustomerPage() {

        driver.findElement(buttonCustomer).click();
        return new NewCustomerPage(driver);
    }

    public NewAccountPage openNewAccountPage() {
        driver.findElement(buttonNewAccount).click();

        return new NewAccountPage(driver);
    }
}
