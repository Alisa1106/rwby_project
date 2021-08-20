package pages

import geb.Page

class GoogleSearchPage extends Page {

    static url = "https://www.google.com/"
    static at = {
        title == "Google"
    }
    static content = {
        searchInputField { $("input", name: "q") }
        searchButton { $("div.FPdoLc").find("input", name: "btnK") }
    }
}