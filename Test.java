import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;

public class Test {
  public static void main(String[] args){
    try{
      UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).
      userAgent.visit("https://www.ultimate-guitar.com/search.php?search_type=title&value=weird%20fishes");                        //visit a url
      System.out.println(userAgent.doc.innerHTML());               //print the content as HTML
    }
    catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
      System.err.println(e);
      //
    }
  }
}
