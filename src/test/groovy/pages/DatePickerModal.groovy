package pages

class DatePickerModal extends MainRwSitePage {

    static content = {
        datePicker { $("#ui-datepicker-div") }
        currentDate { $(".ui-state-highlight") }
        datesList { $("a.ui-state-default") }
        neededDate { datesList[5] }
    }
}