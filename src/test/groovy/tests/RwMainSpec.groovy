package tests


import pages.MainRwSitePage

class RwMainSpec extends BaseSpec {

    def copyrightTextValue = "© 2021 Belarusian Railway"
    def buttonsNamesList = ["Passenger Services", "Freight", "Corporate"]

    def "Open rw.by main page"() {

        when: "Open rw.by"
        to MainRwSitePage

        and: "Choose english language"
        englishLanguageButton.click()

        then: "Check 6 news are displayed into the 'News' section"
        newsList.size() >= 6

        and: "Check, that text '© 2021 Belarusian Railway' is displayed in the bottom of the page"
        copyrightTextFirstLine == copyrightTextValue

        then: "Check 3 buttons are present in the top part of the page: 'Passenger Services', 'Freight', 'Corporate'"
        buttonsNamesList[0].equalsIgnoreCase(passengerServiceButton.text())
        buttonsNamesList[1].equalsIgnoreCase(freightButton.text())
        buttonsNamesList[2].equalsIgnoreCase(corporateButton.text())
    }
}