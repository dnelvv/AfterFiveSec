package org.example.afterfivesec;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void visableAfterFiveSec() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait waitingForVisable = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitingForVisable.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#visibleAfter")));
        driver.findElement(By.cssSelector("#visibleAfter")).click();
    }
}