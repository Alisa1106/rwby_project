/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver


String brow = System.getenv("Browser")
switch (brow) {
    case "chrome":
        WebDriverManager.chromedriver().setup()
        driver = { new ChromeDriver() }
        break
    case "firefox":
        WebDriverManager.firefoxdriver().setup()
        driver = { new FirefoxDriver() }
        break
    default:
        WebDriverManager.firefoxdriver().setup()
        driver = { new FirefoxDriver() }
}

waiting {
    timeout = 10
}

environments {

    // run via “./gradlew chromeTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        WebDriverManager.chromedriver().setup()
        driver = { new ChromeDriver() }
    }

    // run via “./gradlew chromeHeadlessTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chromeHeadless {
        driver = {
//			WebDriverManager.chromedriver().setup()
            ChromeOptions o = new ChromeOptions()
            o.addArguments('headless')
            new ChromeDriver(o)
        }
    }

    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        atCheckWaiting = 1

        driver = { new FirefoxDriver() }
    }
}

// To run the tests with all browsers just run “./gradlew test”

