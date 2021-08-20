package utils

import org.apache.commons.lang3.RandomStringUtils
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class SpecUtil {

    static def getRandomString() {
        def charset = (('A'..'Z') + ('0'..'9')).join()
        def length = 20
        return RandomStringUtils.random(length, charset.toCharArray())
    }

    static def getWait(WebDriver driver, def titleText) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs(titleText))
    }
}