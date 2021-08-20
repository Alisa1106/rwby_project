package tests


import pages.MainRwSitePage

class RwMainSpec extends BaseSpec {

    final COPYRIGHT_TEXT_VALUE = "© 2021 Belarusian Railway"
    final BUTTONS_NAMES_LIST = ["Passenger Services", "Freight", "Corporate"]

    def "Open rw.by main page"() {

        when: "Open rw.by"
        to MainRwSitePage

        and: "Choose english language"
        languageButtonModule.englishLanguageButton.click()

        then: "Check 6 news are displayed into the 'News' section"
        newsList.size() >= 6

        and: "Check, that text '© 2021 Belarusian Railway' is displayed in the bottom of the page"
        copyrightTextFirstLine == COPYRIGHT_TEXT_VALUE

        then: "Check 3 buttons are present in the top part of the page: 'Passenger Services', 'Freight', 'Corporate'"
        BUTTONS_NAMES_LIST[0].equalsIgnoreCase(topButtonModule.passengerServiceButton.text())
        BUTTONS_NAMES_LIST[1].equalsIgnoreCase(topButtonModule.freightButton.text())
        BUTTONS_NAMES_LIST[2].equalsIgnoreCase(topButtonModule.corporateButton.text())
    }
}