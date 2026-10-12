package JavaVersionCheck;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class javaVersionCheck {

    @Test
    public void testJavaFeatureVersion() {
        int featureVersion = Runtime.version().feature();
        System.out.println("Java feature version: " + featureVersion);

        Assert.assertEquals(featureVersion, 22, "Project requires Java 22");

        List<Integer> supportedVersions = List.of(8, 11, 17, 21,22);
        Assert.assertTrue(supportedVersions.contains(featureVersion), "Unsupported Java version: " + featureVersion);
    }
}