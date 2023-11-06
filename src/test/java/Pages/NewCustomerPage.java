package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewCustomerPage {
    public WebDriver driver;

    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerPage = By.xpath("//p[@class='heading3']");
    private By customerName = By.xpath("//input[@name='name']");
    private By genderMale = By.xpath("//input[@value='m']");
    private By genderFemale = By.xpath("//input[@value='f']");

//    private By dateOfBirth = By.xpath("//input[@name='dob']");
    private By address = By.xpath("//textarea[@name='addr']");
    private By city = By.xpath("//input[@name='city']");
    private By state = By.xpath("//input[@name='state']");
    private By Pin = By.xpath("//input[@name='pinno']");
    private By mobileNumber = By.xpath("//input[@name='telephoneno']");
    private By email = By.xpath("//input[@name='emailid']");
    private By passsword = By.xpath("//input[@name='password']");
    private By submit = By.xpath("//input[@name='sub']");
    private By reset = By.xpath("//input[@name='res']");
    private By homeButton = By.xpath("/html/body/p/a");


    public boolean checkHeader() {
        return driver.findElement(headerPage).getText().equals("Add New Customer");
    }

    public void addNewCustomer() {
        driver.findElement(customerName).sendKeys("ABCD");
        driver.findElement(genderMale).click();
//        driver.findElement(genderFemale).click();s
//        driver.findElement(dateOfBirth).sendKeys("01/02/2002");
        driver.findElement(address).sendKeys("America");
        driver.findElement(city).sendKeys("NewYork");
        driver.findElement(state).sendKeys("www");
        driver.findElement(Pin).sendKeys("123456");
        driver.findElement(mobileNumber).sendKeys("22223222");
        driver.findElement(email).sendKeys("abcd@gmail.com");
        driver.findElement(passsword).sendKeys("abcd");
        driver.findElement(submit).click();
//        driver.findElement(reset).click();
//        driver.findElement(homeButton).click();
        driver.switchTo().alert().accept();

    }


}
