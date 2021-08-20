package pages

import org.openqa.selenium.support.ui.WebDriverWait

class MainRwSitePage extends RwHeader {

    static url = "https://www.rw.by/"
    static at = {
        def titleList = [
                "Афіцыйны сайт - Беларуская чыгунка",
                "Официальный сайт - Белорусская железная дорога",
                "Official Web-site - Belarusian Railway"
        ]
        titleList.any(element -> element == title)
    }
    static content = {
        newsList { $("dt") }
        copyrightText { $("div.copyright") }
        copyrightTextFirstLine { copyrightText.text().substring(0, 25) }
        pageContant { $(".index-top") }
        fromInputField { $("#acFrom") }
        toInputField { $("#acTo") }
        calendarButton { $("#fTickets .calendar") }
        dateInputField { $("#yDate") }
        foundButton { $($("#tickets_form input", type: "submit")) }
    }
}