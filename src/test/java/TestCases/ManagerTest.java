package TestCases;

import Pages.Managerpage;
import Pages.NewAccountPage;
import Pages.NewCustomerPage;
import Pages.SignInPage;
import dovanbang.com.testLogin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManagerTest extends testLogin{
    private WebDriver driver;

    private Managerpage managerpage;

    private SignInPage signInPage;

    private NewCustomerPage newCustomerPage;

    private NewAccountPage newAccountPage;

    @BeforeClass
    public void setUp(){
        this.driver = getDriver();
    }

    @Test (priority = 0)
    public void singInPage() throws Exception {
        signInPage = new SignInPage(driver);
        managerpage = signInPage.SignIn("mngr533163", "arUhegU");
        Thread.sleep(2000);
    }
//    @Test (priority = 1)
//    public void openPagenNewCustomer() throws InterruptedException {
////        managerpage = new Managerpage(driver);
//        newCustomerPage = managerpage.openNewCustomerPage();
//
//        Thread.sleep(2000);
//    }
//
//    @Test (priority = 2)
//    public void addNewCustomer() throws InterruptedException {
//        newCustomerPage.addNewCustomer();
//        Thread.sleep(2000);
//    }

    @Test (priority = 3)
    public void openNewAccountPage() throws InterruptedException {
        newAccountPage = managerpage.openNewAccountPage();
        Thread.sleep(2000);

    }

    @Test (priority = 4)
    public void addNewAccount() throws InterruptedException {
        newAccountPage.addNewAccountForm();
        Thread.sleep(2000);
    }


//    @AfterClass
//    public void closeBrowser() {
//        driver.close();
//    }
}
