package com.example.administrator.kotlinproject.model

/**
 * Created by Administrator on 5/23/2018.
 */
class Event {

    var headerInfo: HeaderInfo? = null
    var events : List<eventsInfo>? = null

    class HeaderInfo {

        var name : String? = null
        var email : String? = null
        var detail : String? = null
        var mobile_number : String? = null
        var date_of_birth : String? = null
        var total_amount_of_donation : String? = null
        var total_donation_bill : String? = null
        var total_donation_success : String? = null
        var profile_picture : String? = null
    }

    class eventsInfo{
        var id_event : String? = null
        var department : String? = null
        var event_title : String? = null
        var description : String? = null
        var budgets : String? = null
        var raised : String? = null
        var progress : String? = null
        var date_of_event : String? = null
        var event_preview : String? = null
        var total_contributor : String? = null
        var rating : String? = null
        var like : String? = null
    }
}