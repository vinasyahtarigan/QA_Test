package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Settings;
import static org.junit.Assert.assertTrue;

//import page.utils.Captures;
public class Step {
    WebDriver driver=new ChromeDriver();

    @Given("^User Already Login onto the Website$")
    public void user_already_login_onto_the_website() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ChromeDriver\\chromedriver.exe");
        driver.navigate().to("https://www.bhinneka.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='btn login-links']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Settings.getUserEmail());
        driver.findElement(By.xpath("//button[@id='next']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Settings.getPassword());

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']")).click();

        new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='ant-btn ant-btn-primary']")));

    }

    @When("^User Add Product to Cart\"([^\"]*)\"$")
    public void user_add_product_to_cart(String arg1) {
            driver.findElement(By.xpath("//div[@class='row main-menu-merchant']//input[@placeholder='Cari produk asli...']")).sendKeys(arg1);
            driver.findElement(By.xpath("//div[@class='bt-search-suggestion']//li[2]//a[1]")).click();
            driver.findElement(By.xpath("//a[@id='atc']")).click();
            driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
    }

    @Then("^User Succesfully Add Product to Cart$")
    public void user_succesfully_add_product_to_cart() throws Throwable {
        driver.findElement(By.xpath("//img[@class='navbar-cart__icon']")).click();
        WebElement buttoncheckout = driver.findElement(By.xpath("//button[@id='submit-checkout']"));
        assertTrue(buttoncheckout!=null);
    }

}

