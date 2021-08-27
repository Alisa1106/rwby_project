package tests


import pages.MainRwSitePage

class RwMainSpec extends BaseSpec {

    final COPYRIGHT_TEXT_VALUE = "© 2021 Belarusian Railway"

    def "Check ability to change language at main page, check news, copyright text and 3 buttons on top page is displayed"() {

        when: "Open rw.by"
        to MainRwSitePage

        and: "Choose english language"
        languageButtonModule.englishButton.click()

        then: "Check 5 news are displayed into the 'News' section"
        newsList.size() >= 5

        and: "Check, that text '© 2021 Belarusian Railway' is displayed in the bottom of the page"
        copyrightTextFirstLine == COPYRIGHT_TEXT_VALUE

        then: "Check that 'Passenger Services' button is presents"
        topButtonModule.passengerServicesButton.displayed

        and: "Check that 'Freight' button is presents"
        topButtonModule.freightButton.displayed

        and: "Check that 'Corporate' button is presents"
        topButtonModule.corporateButton.displayed
    }
}