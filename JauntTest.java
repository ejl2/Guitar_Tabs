import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;

public class JauntTest {


  public static void main(String[] args){
    UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).

    try{
      userAgent.visit("https://www.ultimate-guitar.com/search.php?search_type=title&value=weird%20fishes");                        //visit a url
      System.out.println(userAgent.doc.outerHTML());               //print the content as HTML
    }
    catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
      System.err.println(e);
      //
    }

    Elements ugSearchResults;
    ugSearchResults = userAgent.doc.findEvery("<div class=_1iQi2>");
    System.out.println("size: " + ugSearchResults.size());

  }
}
