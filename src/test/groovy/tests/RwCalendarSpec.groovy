package tests

import pages.ChosenTrainTimetableRwPage
import pages.DatePickerRwModal
import pages.MainRwSitePage
import pages.TimetableRwPage
import utils.SpecUtil

class RwCalendarSpec extends BaseSpec {

    final BREST_CITY = "Брест"
    final MINSK_CITY = "Минск"
    final TIME_TABLE_PAGE_TITLE = "Расписание поездов БЖД | Купить билеты на поезд"
    final MAIN_PAGE_TITLE = "Официальный сайт - Белорусская железная дорога"

    def "Check ability to choose route and trip date, print found trains, correct opening trains link and return to main page"() {

        when: "Open rw.by"
        to MainRwSitePage

        and: "Write text 'Брест' in 'Откуда:' input field"
        fromInputField.value BREST_CITY

        and: "Write text 'Минск' in 'Куда:' input field"
        toInputField.value MINSK_CITY

        and: "Click calendar button"
        calendarButton.click()

        then: "Check that date picker modal opened"
        at DatePickerRwModal

        when: "Write date from 5 days from today in date input field"
        neededDate.click()

        and: "Click found button"
        foundButton.click()
        SpecUtil.getTitleWait(driver, TIME_TABLE_PAGE_TITLE)


        then: "Check timetable page content"
        at TimetableRwPage

        and: "Print trains names and their departure times"
        int index = 0
        for (trainInfo in trainsInfoList) {
            println trainsList[index].text() + " - " + departureTimesList[index].text()
            index++
        }

        when: "Click first train link"
        def trainName = firstTrainsListLink.text()
        firstTrainsListLink.click()

        then: "Check chosen train timetable page content"
        at ChosenTrainTimetableRwPage

        and: "Check train name"
        chosenTrainData.text().substring(6) == trainName

        and: "Check text 'Режим курсирования:' is not empty"
        def cruisingDaysText = cruisingDays.text().substring(20)
        cruisingDaysText.length() > 0

        when: "Click go to main page link"
        goToMainPageLink.click()

        then: "Check that there was a transition to main page"
        waitFor {
            withWindow({ title == MAIN_PAGE_TITLE }) {
                at MainRwSitePage
            }
        }
    }
}