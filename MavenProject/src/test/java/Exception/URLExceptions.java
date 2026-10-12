package Exception;

public class URLExceptions extends RuntimeException {
    public URLExceptions(String expectedUrl, String actualUrl) {
        super(String.format(
                "\n[URL MISMATCH ERROR]:" +
                        "\n  Expected URL : %s" +
                        "\n  Actual URL   : %s",
                expectedUrl, actualUrl
        ));
    }

    public URLExceptions(String message) {
        super(message);
    }
}

