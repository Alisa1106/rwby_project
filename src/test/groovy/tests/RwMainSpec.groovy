package tests


import pages.MainRwSitePage

class RwMainSpec extends BaseSpec {

    final COPYRIGHT_TEXT_VALUE = "© 2021 Belarusian Railway"

    def "Check ability to change language at main page, check news, copyright text and 3 buttons on top page is displayed"() {

        when: "Open rw.by"
        to MainRwSitePage

        and: "Choose english language"
        languageButtonModule.chooseLanguageButton("ENG").click()

        then: "Check 5 news are displayed into the 'News' section"
        newsList.size() >= 5

        and: "Check, that text '© 2021 Belarusian Railway' is displayed in the bottom of the page"
        copyrightTextFirstLine == COPYRIGHT_TEXT_VALUE

        then: "Check 3 buttons are present in the top part of the page: 'Passenger Services', 'Freight', 'Corporate'"
        topButtonModule.pageTopButtonsList("PASSENGER SERVICES").displayed
        topButtonModule.pageTopButtonsList("FREIGHT").displayed
        topButtonModule.pageTopButtonsList("CORPORATE").displayed
    }
}