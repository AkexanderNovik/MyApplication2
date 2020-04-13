package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    @Test
    fun test_main_activity() {
        val activityScanario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.mainAction)).check(matches(isDisplayed()))
        onView(withId(R.id.goToAddProduct)).check(matches(isDisplayed()))

        onView(withId(R.id.goToAddProduct)).perform(click())
        onView(withId(R.id.add_product_action)).check(matches(isDisplayed()))

    }
}


