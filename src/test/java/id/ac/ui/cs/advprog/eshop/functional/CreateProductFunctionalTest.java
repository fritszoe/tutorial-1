package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.List;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;
    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d/product", testBaseUrl, serverPort);
    }

    @Test
    void testProductCreation(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/list");
        WebElement createProductButton = driver.findElement(By.id("createProductButton"));

        createProductButton.click();
        assertEquals(baseUrl + "/create", driver.getCurrentUrl());

        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        WebElement submitButton = driver.findElement(By.id("submitButton"));

        productNameInput.clear();
        productNameInput.sendKeys("High Grade Zaku II 1/144 scale");

        productQuantityInput.clear();
        productQuantityInput.sendKeys("10");

        submitButton.click();
        assertEquals(baseUrl + "/list", driver.getCurrentUrl());

        WebElement productListBody = driver.findElement(By.id("product-list")).findElement(By.tagName("tbody"));
        List<WebElement> rows = productListBody.findElements(By.tagName("tr"));
        assertEquals(1, rows.size());

        for (WebElement row:rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            int colNum = 0;
            for (WebElement col:cols) {
                if (colNum == 0) {
                    assertEquals("High Grade Zaku II 1/144 scale", col.getText());
                }
                if (colNum == 1) {
                    assertEquals("10", col.getText());
                }
                if (colNum++ > 2) {
                    break;
                }
            }
        }
    }
}
