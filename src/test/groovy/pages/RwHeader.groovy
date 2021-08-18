package pages

import geb.Page

class RwHeader extends Page {

    static content = {
        chooseLanguageButtons { $(".top-lang__item") }
        russianLanguageButton { chooseLanguageButtons[0] }
        belarussianLanguageButton { chooseLanguageButtons[1] }
        englishLanguageButton { chooseLanguageButtons[2] }
        pageTopButtonsList { $(".menu-items a b") }
        passengerServiceButton { pageTopButtonsList[1] }
        freightButton { pageTopButtonsList[3] }
        corporateButton { pageTopButtonsList[4] }
        headerSearchField { $("#searchinp") }
        headerSearchButton { $("Button", type: "submit") }
    }
}