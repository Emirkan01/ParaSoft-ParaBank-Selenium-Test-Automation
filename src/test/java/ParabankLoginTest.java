import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParabankLoginTest {
    @Test
    public void successful_login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        driver.findElement(By.name("username")).sendKeys("eeeeeee1");
        driver.findElement(By.name("password")).sendKeys("9fpd7FbAMdRV@");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void incomplete_username() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        driver.findElement(By.name("username")).sendKeys("eee1");
        driver.findElement(By.name("password")).sendKeys("9fpd7FbAMdRV@");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.quit();
    }
    @Test
    public void incomplete_password() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        driver.findElement(By.name("username")).sendKeys("eeeeeee1");
        driver.findElement(By.name("password")).sendKeys("9fpd7FbAM");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.quit();
    }

    @Test
    public void directing_home_page() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        driver.findElement(By.cssSelector("[class='home']")).click();
        driver.quit();
    }
    @Test
    public void directing_abous_page() {
        WebDriver driver = new ChromeDriver();
        try{
            driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
            driver.findElement(By.cssSelector("[class = 'aboutus']")).click();
        } catch (Exception e) {
            System.err.println("Could not navigate to Abous us page:" + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}