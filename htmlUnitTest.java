// use "javac -cp .;lib\* htmlUnitTest.java" to compile
// use "java -cp .;lib\* htmlUnitTest" to run

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.css.*;
import netscape.javascript.*;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import java.io.*;
import java.util.*;

public class htmlUnitTest {

    public static void main(String[] args){

      //initialize headless browser as FIREFOX_60 emulator
      WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);
      //enable javascript
      webClient.getOptions().setJavaScriptEnabled(true);
      webClient.getOptions().setThrowExceptionOnScriptError(false);
      webClient.getOptions().setCssEnabled(false);
      webClient.setAjaxController(new NicelyResynchronizingAjaxController());
      HtmlPage page = null;
      int scriptCount = 1234;
      int limit = 0;

      try {
          //visit ugPage
          page = webClient.getPage("https://www.ultimate-guitar.com/search.php?search_type=title&value=weird%20fishes");

          //wait for javascript
          while (!page.asText().contains("_1iQi2") && limit < 1000 && scriptCount > 1) {
            scriptCount = webClient.waitForBackgroundJavaScript(1000);
            limit++;
            System.out.println(limit + " of 1000 " + "Waiting for javascript" + "ScriptCount: " + scriptCount);
          }
      } catch (IOException ex ) {
          ex.printStackTrace();
      }

        System.out.println("THIS: " + page.asXml());
        List<HtmlDivision> hits = page.getByXPath("//div[@class= '_1iQi2']");
        System.out.println(scriptCount);
        System.out.println(hits.size());
        System.out.println(hits.get(0).asXml());

        // HtmlPage refreshedPage  = ((HtmlPage) page.getEnclosingWindow().getEnclosedPage());
        //
        // while (!page.asText().contains("_1iQi2") && limit < 14000) {
        //   scriptCount = webClient.waitForBackgroundJavaScript(1000);
        //   limit++;
        //   System.out.println(limit + " of 14000 " + "Waiting for javascript");
        // }
        //
        // System.out.println("THIS: " + refreshedPage.asXml());
        // List<HtmlDivision> hits = refreshedPage.getByXPath("//div[@class= '_1iQi2']");
        // System.out.println(scriptCount);
        // System.out.println(hits.size());
        // System.out.println(hits.get(0).asXml());
    }
}
