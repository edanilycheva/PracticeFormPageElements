package servise;


import com.codeborne.selenide.logevents.SelenideLog;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

import static com.codeborne.selenide.logevents.LogEvent.EventStatus.FAIL;
import static com.codeborne.selenide.logevents.LogEvent.EventStatus.PASS;

    public class CustomAssert {

        public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
            if (!matcher.matches(actual)) {
                Description description = new StringDescription();
                description.appendText("\nExpected: ")
                        .appendDescriptionOf(matcher)
                        .appendText("\n     but: ");
                matcher.describeMismatch(actual, description);

                SelenideLog log = SelenideLogger.beginStep("assertThat", description.toString());
                SelenideLogger.commitStep(log, FAIL);

                throw new AssertionError(description.toString());
            } else {
                SelenideLog log = SelenideLogger.beginStep("assertThat", matcher.toString());
                SelenideLogger.commitStep(log, PASS);
            }
        }

    }