package pages

import geb.Page

class TimetablePage extends Page {

    static at = {
        title == "Расписание поездов БЖД | Купить билеты на поезд"
    }

    static content = {
        trainInfoList { $(".sch-table__row-wrap") }
        trainsList { $(".train-route") }
        departureTimesList { $(".train-from-time") }
        firstTrainsListLink { trainsList[0] }
        chosenTrainData { $(".sch-title__title") }
        cruisingDays { $(".sch-title__descr") }
    }
}