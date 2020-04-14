package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matchers.not
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest2 {
    @Test
    fun test_main_activity() {
        val activityScanario = ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(withId(R.id.content_main_Action))
            .check(matches(isDisplayed()))

        //erase not() statement th pass the test
        Espresso.onView(withId(R.id.goToAddProduct))
            .check(matches(not(isDisplayed())))

        Espresso.onView(withId(R.id.goToAddProduct)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.add_product_action))
            .check(matches(isDisplayed()))
    }

    @Test
    fun AddProductActivityTest() {
        val activityScanario = ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(2000)
//        onView(withId(R.id.content_main_Action)).check(matches(isDisplayed()))
        PageObject.checkWithId(R.id.content_main_Action)
        Espresso.onView(withId(R.id.goToAddProduct))
            .check(matches(isDisplayed()))

        Espresso.onView(withId(R.id.goToAddProduct)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.add_product_action))
            .check(matches(isDisplayed()))

        Thread.sleep(2000)
        Espresso.onView(withId(R.id.addProductSubmitButton))
            .check(matches(isDisplayed()))

        Espresso.onView(withHint("Product name"))
            .check(matches((isDisplayed())))
        Espresso.onView(withHint("Owner name"))
            .check(matches((isDisplayed())))
        //onView(withHint("Purchasing date")).check(matches(isDisplayed()))
        PageObject.checkWithHint("Purchasing date")

        Espresso.onView(withId(R.id.addProductSubmitButton))
            .perform(ViewActions.click())
        Thread.sleep(2000)
        Espresso.pressBack()
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.content_main_Action))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.goToAddProduct))
            .check(matches(isDisplayed()))
    }
}