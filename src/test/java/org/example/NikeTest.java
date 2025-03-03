package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NikeHomePage;

public class NikeTest extends BaseTest {


    @Test
    void test1() throws InterruptedException {

        NikeHomePage test = new NikeHomePage();
        test.selectItem();
        Assert.assertTrue(false);
    }

    @Test(enabled = false)
    void test2() throws InterruptedException {

        NikeHomePage test = new NikeHomePage();
        test.selectItem();
    }

    @Test(enabled = false)
    void test3() throws InterruptedException {

        NikeHomePage test = new NikeHomePage();
        test.selectItem();
    }

    @Test(enabled = false)
    void test4() throws InterruptedException {

        NikeHomePage test = new NikeHomePage();
        test.selectItem();
    }
}
