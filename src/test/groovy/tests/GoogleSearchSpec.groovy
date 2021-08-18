package tests

import pages.GoogleFoundPage
import pages.GoogleSearchPage
import pages.MainRwSitePage

class GoogleSearchSpec extends BaseSpec {

    def textValue = "белорусская железная дорога"

    def "Go to google.com page, write text in input field and go to searching site"() {

        when: "Go to google.com"
        to GoogleSearchPage

        and: "Write text 'белорусская железная дорога' in input field"
        searchInputField.value textValue

        and: "Click search button"
        searchButton.click()

        then: "Check title"
        at GoogleFoundPage

        when: "Click first search result"
        firstSearchResult.click()

        then: "Go to main rw.by page"
        to MainRwSitePage

        when: "Change site language to russian"
        russianLanguageButton.click()

        then: "Check title"
        at MainRwSitePage
    }
}