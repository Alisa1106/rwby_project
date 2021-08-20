package modules

import geb.Module

class LanguageButtonModule extends Module {

    static content = {
        chooseLanguageButton { $(".top-lang__item") }
        russianLanguageButton { chooseLanguageButton[0] }
        belarussianLanguageButton { chooseLanguageButton[1] }
        englishLanguageButton { chooseLanguageButton[2] }
    }
}