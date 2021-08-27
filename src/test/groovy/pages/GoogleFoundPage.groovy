package pages

import geb.Page

class GoogleFoundPage extends Page {

    static at = {
        title.startsWith("белорусская железная дорога")
    }
    static content = {
        searchResults { $("div.yuRUbf").find("a") }
        firstSearchResult { searchResults[0] }
    }
}