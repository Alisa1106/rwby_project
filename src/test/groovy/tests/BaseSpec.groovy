package tests

import geb.spock.GebSpec

class BaseSpec extends GebSpec {

    void setup() {
        browser.getDriver().manage().window().maximize()
    }
}