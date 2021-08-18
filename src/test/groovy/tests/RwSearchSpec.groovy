package tests


import pages.MainRwSitePage
import pages.SearchRwSitePage
import utils.SpecUtil

class RwSearchSpec extends BaseSpec {

    String randomString = SpecUtil.getRandomString()
    String searchingBaseUrl = "https://www.rw.by/search/?s=Y&q="
    String nothingFoundText = "К сожалению, на ваш поисковый запрос ничего не найдено."

    def "Open rw.by main page"() {

        when: "Open rw.by"
        to MainRwSitePage

        and: "Write random string in input field"
        headerSearchField.value randomString

        and: "Click search button"
        headerSearchButton.click()

        then: "Check title"
        at SearchRwSitePage

        and: "Check current URL"
        currentUrl == searchingBaseUrl + randomString

        then: "Check text"
        nothingFoundInfoMessage.text() == nothingFoundText

        when: "Clear search input field"
        searchInputField.value ""

        and: "Write text 'Минск' in input field"
        searchInputField.value "Минск"

        and: "Click search button"
        findButton.click()

        then: "Check 10 links to the articles are displayed on a screen"
        articleLinksList.size() >= 10

        and: "Write into the console text from found links"
        for (def linkText in articleLinksList)
            println linkText.text()
    }
}