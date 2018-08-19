// use "javac -cp .;lib\* htmlUnitTest.java" to compile
// use "java -cp .;lib\* htmlUnitTest" to run

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.css.*;
import netscape.javascript.*;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import java.io.*;
import java.util.*;

public class htmlUnitTest {

    public static void main(String[] args){
      WebClient webClient = new WebClient(BrowserVersion.CHROME);
      HtmlPage page = null;
      int scriptCount = 1234;
      try {

            page = webClient.getPage("https://www.ultimate-guitar.com/search.php?search_type=title&value=weird%20fishes");
            webClient.getOptions().setJavaScriptEnabled(true);
            scriptCount = webClient.waitForBackgroundJavaScript(3000 * 1000);

            int limit = 0;
            while (scriptCount > 1 && limit < 500) {
              scriptCount = webClient.waitForBackgroundJavaScript(1000);
              System.out.println(scriptCount);
              limit++;
            }
        } catch (IOException ex ) {
            //ex.printStackTrace();
            //System.out.println("error");
        }

        System.out.println("THIS: " + page.asXml());
        List<HtmlDivision> hits = page.getByXPath("//div[@class='_1iQi2']");
        System.out.println(scriptCount);
        System.out.println(hits.size());
        System.out.println(hits.get(1).asXml());
    }
}
