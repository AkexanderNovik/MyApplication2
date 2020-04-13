package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    @Test
    fun test_main_activity() {
        val activityScanario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.content_main_Action)).check(matches(isDisplayed()))
        onView(withId(R.id.goToAddProduct)).check(matches(isDisplayed()))

        onView(withId(R.id.goToAddProduct)).perform(click())
        onView(withId(R.id.add_product_action)).check(matches(isDisplayed()))
    }

    @Test
    fun AddProductActivityTest() {
        val activityScanario = ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(2000)
        onView(withId(R.id.content_main_Action)).check(matches(isDisplayed()))
        onView(withId(R.id.goToAddProduct)).check(matches(isDisplayed()))

        onView(withId(R.id.goToAddProduct)).perform(click())
        onView(withId(R.id.add_product_action)).check(matches(isDisplayed()))

        Thread.sleep(2000)
        onView(withId(R.id.addProductSubmitButton)).check(matches(isDisplayed()))

        onView(withHint("Product name")).check(matches((isDisplayed())))
        onView(withHint("Owner name")).check(matches((isDisplayed())))
        onView(withHint("Purchasing date")).check(matches(isDisplayed()))

        onView(withId(R.id.addProductSubmitButton)).perform(click())
        Thread.sleep(2000)
        pressBack()
        Thread.sleep(2000)
        onView(withId(R.id.content_main_Action)).check(matches(isDisplayed()))
        onView(withId(R.id.goToAddProduct)).check(matches(isDisplayed()))
    }
}


