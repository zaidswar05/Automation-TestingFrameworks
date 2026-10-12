package Annotations;

import org.testng.annotations.*;

public class Annotation {


    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("In BeforeMethod");
    }
    @AfterSuite
    public void AfterSuite() {
        System.out.println("In AfterSuite");
    }
    @BeforeClass
    public void BeforeClass() {
        System.out.println("In BeforeClass");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("In AfterMethod");
    }
    @AfterClass
    public void AfterClass() {
        System.out.println("In AfterClass");
    }
    @AfterTest
    public void AfterTest() {
        System.out.println("In AfterTest");
    }



    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("In BeforeSuite");
    }
    @BeforeTest
    public void BeforeTest() {
        System.out.println("In BeforeTest");
    }
    @Test
    public void Test() {
        System.out.println("In Test");
    }
    @BeforeSuite
    public void ABeforeSuite() {
        System.out.println("In ABeforeSuite");
    }
    @BeforeSuite
    public void CBeforeSuite() {
        System.out.println("In CBeforeSuite");
    }



}
