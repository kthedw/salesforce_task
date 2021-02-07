package com.salesforce;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Stanislav Sukharev on 07.02.21.
 */
public class FirstTest {

    @Test
    public void firstTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources//drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. 1) Зайти на страницу help.salesforce.com
        driver.get("https://help.salesforce.com/");

        // 2. В инпут на странице написать outlook for salesforce
        WebElement search = driver.findElement(By.xpath("//input[@aria-label='Search']"));
        search.clear();
        search.sendKeys("outlook for salesforce");

        // 3. Нажать на иконку лупы
        driver.findElement(By.xpath("//tds-header-search/div[@id='tds-header-search']/div[1]/span[1]/*[1]")).click();

        // 4. На следующей странице в блоке Content Type выбрать Quick Starts
        driver.findElement(By.cssSelector("#ArticleTypeFacet .coveo-facet-more-icon")).click();
        driver.findElement(By.cssSelector("#ArticleTypeFacet .coveo-facet-value:nth-child(12) .coveo-facet-value-caption")).click();
        Thread.sleep(3000);

        // 5. Кликнуть на первый результат на странице
        driver.findElement(By.cssSelector(".CoveoResultLink > .highlight:nth-child(3)")).click();
        Thread.sleep(5000);

        // 6. На следующей странице проверить, что блок Related Resources присутствует
        driver.findElement(By.cssSelector("#relatedresources_articleview .card-title"));

        // 7. Кликнуть на первый результат в блоке Related Resources
        driver.findElement(By.linkText("Salesforce for Outlook")).click();

        // 8. Проверить, что странице не показывает ошибку 404
        Assert.assertFalse(driver.getTitle().contains("404"));
        Thread.sleep(5000);

        driver.quit();


    }

}

