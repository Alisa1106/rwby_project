package pages

class DatePickerRwModal extends MainRwSitePage {

    static at = {
        datePicker.displayed
    }
    static content = {
        datePicker { $("#ui-datepicker-div") }
        datesList { $("a.ui-state-default") }
        neededDate { datesList[5] }
    }
}