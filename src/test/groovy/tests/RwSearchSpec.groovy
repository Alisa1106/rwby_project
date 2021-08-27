package tests


import pages.MainRwSitePage
import pages.SearchRwSitePage
import utils.SpecUtil

class RwSearchSpec extends BaseSpec {

    final RANDOM_STRING = SpecUtil.getRandomString()
    final SEARCHING_BASE_URL = "https://www.rw.by/search/?s=Y&q="
    final NOTHING_FOUND_TEXT = "К сожалению, на ваш поисковый запрос ничего не найдено."
    final RW_SEARCH_PAGE_TITLE = "Результаты поиска - Белорусская железная дорога"

    def "Check search on rw.by site"() {

        when: "Open rw.by"
        to MainRwSitePage

        and: "Write random string in input field"
        headerSearchField.value RANDOM_STRING

        and: "Click search button"
        headerSearchButton.click()
        SpecUtil.getTitleWait(driver, RW_SEARCH_PAGE_TITLE)

        then: "Check title"
        at SearchRwSitePage

        and: "Check current URL"
        currentUrl == SEARCHING_BASE_URL + RANDOM_STRING

        then: "Check text"
        nothingFoundInfoMessage.text() == NOTHING_FOUND_TEXT

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