package tests

import pages.DatePickerModal
import pages.MainRwSitePage
import pages.TimetablePage
import utils.SpecUtil

class RwCalendarSpec extends BaseSpec {

    final BREST_CITY = "Брест"
    final MINSK_CITY = "Минск"
    final TIME_TABLE_PAGE_TITLE = "Расписание поездов БЖД | Купить билеты на поезд"

    def "Open rw.by main page"() {

        when: "Open rw.by"
        to MainRwSitePage

        and: "Write text 'Брест' in 'Откуда:' input field"
        fromInputField.value BREST_CITY

        and: "Write text 'Минск' in 'Куда:' input field"
        toInputField.value MINSK_CITY

        and: "Click calendar `button"
        calendarButton.click()

        then: "Date picker modal opened"
        at DatePickerModal

        when: "Write date from 5 days from today in date input field"
        neededDate.click()

        and: "Click found button"
        foundButton.click()
        SpecUtil.getWait(driver, TIME_TABLE_PAGE_TITLE)

        then: "Check title"
        at TimetablePage

        and: "Print train name and departure time"
        int count = 0
        for (trainRoute in trainsList) {
            print trainRoute.text() + " - "
            for (departureTime in departureTimesList) {
                if (departureTime.equals(departureTime[count])) {
                    println(departureTime.text())
                }
            }
            count++
        }

        when: "Click first train link"
        trainName = firstTrainsListLink.text()
        firstTrainsListLink.click()

        then: "Check train name"
        chosenTrainData.text().substring(6) == trainName

        and: "Check text 'Режим курсирования:' is not empty"
        def cruisingDaysText = cruisingDays.text().substring(20)
        cruisingDaysText.length() > 0
    }
}