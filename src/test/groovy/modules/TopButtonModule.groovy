package modules

import geb.Module

class TopButtonModule extends Module {

    static content = {
        pageTopButtonsList { String buttonName -> $(".menu-items a b", text: "$buttonName") }
        passengerServicesButton { pageTopButtonsList(TopButtonsNames.PASSENGER_SERVICES.value) }
        freightButton { pageTopButtonsList(TopButtonsNames.FREIGHT.value) }
        corporateButton { pageTopButtonsList(TopButtonsNames.CORPORATE.value) }
    }
}