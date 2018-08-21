import java.io.*;
import java.util.*;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class SearchResult {

private String name;
private int popularity;
private String type;
private boolean isTab = false;
private String link;

    public SearchResult(WebElement html) {

      link = html.findElement(By.cssSelector("a[class='link-primary _1kcZ5']")).getAttribute("href");

      name = html.findElement(By.cssSelector("a[class='link-primary _1kcZ5']")).getText();
      try {
        popularity = Integer.parseInt(html.findElement(By.cssSelector("div[class='_1RJlF _3IBgH']")).getText());
      } catch(NumberFormatException e) {
        popularity = 0;
      }
      type = html.findElement(By.cssSelector("div[class='_1RJlF _2fyaZ']")).getText();

      if (type.equalsIgnoreCase("tab")) {
        isTab = true;
      }
    }

    public String toString() {
      return "\n Name: " + name + " " +
      "\n Type: " + type + " " +
      "\n Popularity: " + popularity +
      "\n Address: " + link + "\n";
    }

    public boolean isTab() {
      return isTab;
    }

    public String getLink() {
      return link;
    }
}
