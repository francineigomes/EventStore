package net.intelie.challenges;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

public class EventTest {
    @Test
    public void thisIsAWarning() throws Exception {
        Event event = new Event("some_type", 123L);
        Logger l = Logger.getLogger(getClass().getName());
        l.info("Type: " + event.type());
        l.info("timeStamp: " + event.timestamp());
        //THIS IS A WARNING:
        //Some of us (not everyone) are coverage freaks.
        assertEquals(123L, event.timestamp());
        assertEquals("some_type", event.type());
    }
}