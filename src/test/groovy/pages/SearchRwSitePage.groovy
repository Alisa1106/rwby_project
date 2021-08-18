package pages

class SearchRwSitePage extends RwHeader {

    static at =
            {
                title == "Результаты поиска - Белорусская железная дорога"
            }
    static content =
            {
                String currentUrl = driver.getCurrentUrl()
                nothingFoundInfoMessage { $("font.notetext") }
                searchInputField { $("#searchinpm") }
                findButton { $("input", type: "submit") }
                articleLinksList { $("li h3 a.name") }
            }
}