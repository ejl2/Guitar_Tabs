// use "javac -cp .;libs\* SeleniumTest.java" to compile
// use "java -cp .;libs\* SeleniumTest" to run

import java.io.*;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;


public class SeleniumTest {

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("window-size=1200x600");

    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.get("https://www.ultimate-guitar.com/search.php?search_type=title&value=weird%20fishes");

    //System.out.println(driver.getPageSource());

    List<WebElement> hits = driver.findElements(By.cssSelector("div[class='_1iQi2']"));
    Vector<WebElement> searchResults = new Vector<WebElement>();
    System.out.println(hits.size());
    for (int i = 0; i < hits.size(); i++) {
      System.out.println(hits.get(i));
      System.out.println(hits.get(i).getText());
      searchResults.add(hits.get(i)); 
    }
  }
}
