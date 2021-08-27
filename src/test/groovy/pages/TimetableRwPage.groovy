package pages

class TimetableRwPage extends TimetableRwCommon {

    static at = {
        title == "Расписание поездов БЖД | Купить билеты на поезд"
        waitFor {
            pageBasicContent.displayed
        }
    }
    static content = {
        pageBasicContent { $("div#sch-route") }
        trainsInfoList { $(".sch-table__row-wrap") }
        trainsList { $(".train-route") }
        departureTimesList { $(".train-from-time") }
        firstTrainsListLink { trainsList[0] }
    }
}