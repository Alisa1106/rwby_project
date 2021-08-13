package pages

import geb.navigator.Navigator

class GoogleSearchPage {

    static content = {
        searchInputField { $("input", name: "q") }

        searchButton {
            Navigator navigator = $("form", name: "f").find(name: "btnK", type: "submit", "input")

        }
    }
}
