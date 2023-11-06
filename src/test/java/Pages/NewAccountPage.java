package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
    public WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By customerID = By.xpath("//input[@name='cusid']");
    private By accountType = By.xpath("//select[@name='selaccount']");
//    private By accountTypeCurrent = By.xpath("//option[value='Current']");

    private By accountTypeIsSavings = By.xpath("option[@value='Savings']");
    private By initialDeposit = By.xpath("//input[@name='inideposit']");


    private By submitButton = By.xpath("//input[@name='button2']");

    public void addNewAccountForm() throws InterruptedException {
        driver.findElement(customerID).sendKeys("1223");

        Select selectAccountType = new Select( driver.findElement(accountType));
//        selectAccountType.selectByVisibleText("Savings");
        selectAccountType.selectByVisibleText("Current");
//        driver.findElement(accountTypeIsSavings).click();
        driver.findElement(initialDeposit).sendKeys("100");
        driver.findElement(submitButton).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
}
