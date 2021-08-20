package pages


import geb.Page
import modules.LanguageButtonModule
import modules.TopButtonModule

class RwHeader extends Page {

    static content = {
        languageButtonModule { module(LanguageButtonModule) }
        topButtonModule { module(TopButtonModule) }
        headerSearchField { $("#searchinp") }
        headerSearchButton { $("Button", type: "submit") }
    }
}