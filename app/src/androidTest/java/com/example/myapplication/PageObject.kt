package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

class PageObject {
    companion object {
        fun checkWithHint(rString: String){
            onView(withHint(rString)).check(matches(isDisplayed()))
        }

        fun checkWithId(rID: Int){
            onView(withId(rID)).check(matches(isDisplayed()))
        }
    }
}