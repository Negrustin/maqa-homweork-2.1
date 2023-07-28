//package com.netology.tabbedapplication;
package com.netology.tabbedapplication.tabnavigation;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.netology.tabbedapplication.MainActivity;
import com.netology.tabbedapplication.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTabNavigationTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void shouldShowPageTwoAfterSelectingTab2() {
        ViewInteraction tabView = onView(allOf(withContentDescription("Tab 2")));
        tabView.check(matches(isDisplayed()));
        tabView.perform(click());

        ViewInteraction textView = onView(allOf(withId(R.id.section_label), withText("Page: 2")));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("Page: 2")));
    }

    @Test
    public void shouldDisplayPageTwoAfterSwipeLeft() {
        onView(isRoot()).perform(swipeLeft());

        ViewInteraction textView = onView(allOf(withId(R.id.section_label), withText("Page: 2")));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("Page: 2")));
    }


}
