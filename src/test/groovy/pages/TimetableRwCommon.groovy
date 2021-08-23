package pages

import geb.Page

class TimetableRwCommon extends Page {

    static content = {
        goToMainPageLink { $("div.menu-foot a") }
    }
}