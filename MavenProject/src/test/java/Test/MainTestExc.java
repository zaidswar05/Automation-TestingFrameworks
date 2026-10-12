package Test;
import Exception.URLExceptions;
public class MainTestExc {
    public static void main(String[] args) {
        //create exceptions with comments in the try catch block

        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = "https://www.automationexercise.com/login";
        //create exceptions with comments in the try catch block

        try {
            throw new URLExceptions(expectedUrl, actualUrl);
        } catch (URLExceptions e) {
            System.err.println(e.getMessage());
        }
    }
}
