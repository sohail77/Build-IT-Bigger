package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by sohail on 22/09/16.
 */
public class GetJokeAsyncTaskTest extends AndroidTestCase {

    public void testJokeDownload() {

        try {
            GetJokeAsyncTask task = new GetJokeAsyncTask();
            task.execute();
            String joke = task.get(30, TimeUnit.SECONDS);

            assertThat(joke, notNullValue());
            assertTrue(joke.length() > 0);

        } catch (Exception e) {
            fail("Operation timed out");
        }
    }

}
