package modules

import geb.Module

class TopButtonModule extends Module {

    static content = {
        pageTopButtonsList { String buttonName -> $(".menu-items a b", text: "$buttonName") }
    }
}