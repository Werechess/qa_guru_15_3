package com.demoqa.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SystemPropertiesTests {

    @Test
    void simplePropertyTest1() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // null
    }

    @Test
    void simplePropertyTest2() {
        System.setProperty("browser", "chrome");
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // chrome
    }

    @Test
    void simplePropertyTest3() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // firefox by default, not null
    }

    @Test
    @Tag("some_test_tag")
    void simplePropertyTest4() {
        System.setProperty("browser", "chrome");
        String browserName = System.getProperty("browser", "firefox");
        System.out.println("test tag " + browserName); // chrome, more priority
    }

    @Test
    @Tag("many_properties_tag")
    void simplePropertyTest5() {
        // gradle clean manyTags -Dbrowser=opera -Dbrowser_version=99 -Dbrowser_size=400x500

        String browserName = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browser_version", "108");
        String browserSize = System.getProperty("browser_size", "1920x1080");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
    }

    @Test
    @Tag("hello")
    void simplePropertyTest6() {
        // gradle clean hello -Duser_name="known person"
        // gradle clean hello "-Duser_name=known person"
        System.out.println("Hello, " + System.getProperty("user_name", "unknown student"));
    }
}
