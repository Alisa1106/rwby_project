package modules

import geb.Module

class LanguageButtonModule extends Module {

    static content = {
        chooseLanguageButton { String buttonName -> $(".top-lang__item", text: "$buttonName") }
        englishButton { chooseLanguageButton(LanguageButtonNames.ENGLISH.value) }
        russianButton { chooseLanguageButton(LanguageButtonNames.RUSSIAN.value) }
    }
}