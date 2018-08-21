// use "javac -cp .;libs\* SeleniumTest.java" to compile
// use "java -cp .;libs\* SeleniumTest" to run

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver.Timeouts.*;


public class SeleniumTest {

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("window-size=1200x600");

    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.ultimate-guitar.com/search.php?search_type=title&value=weird%20fishes");

    //System.out.println(driver.getPageSource());

    List<WebElement> hits = driver.findElements(By.cssSelector("div[class='_1iQi2']"));

    Vector<SearchResult> searchResults = new Vector<SearchResult>();
    System.out.println(hits.size());
    for (int i = 1; i < hits.size(); i++) {
      //System.out.println(hits.get(i));
      searchResults.add(new SearchResult(hits.get(i)));
    }

    System.out.println(searchResults);
    driver.close();


    driver = new ChromeDriver();
    driver.get(searchResults.get(1).getLink());
    //driver.close();
  }
}
