package modules

import geb.Module

class TopButtonModule extends Module {

    static content = {
        pageTopButtonsList { $(".menu-items a b") }
        passengerServiceButton { pageTopButtonsList[1] }
        freightButton { pageTopButtonsList[3] }
        corporateButton { pageTopButtonsList[4] }
    }
}