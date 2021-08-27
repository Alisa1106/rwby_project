package pages

class ChosenTrainTimetableRwPage extends TimetableRwCommon {

    static at = {
        pageBasicContent.displayed
    }
    static content = {
        pageBasicContent { $("div.sch-table-wrap") }
        chosenTrainData { $(".sch-title__title") }
        cruisingDays { $(".sch-title__descr") }
    }
}