package net.intelie.challenges;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

class EventStoreServiceTest {

	@Test
	void testInsert() {
		//fail("Not yet implemented");
    	// Memory allocation
		EventStoreService eventStoreService = new EventStoreService();
		// Creating events
		Event event_01 = new Event("type_01", 123L);
		Event event_02 = new Event("type_02", 223L);
		
        Logger l = Logger.getLogger(getClass().getName());
        l.info("Type: " + event_01.type());
        l.info("Type: " + event_02.type());
        
		eventStoreService.insert(event_01);
		eventStoreService.insert(event_02);
		
		List<Event> events = new ArrayList<Event>();
		events.addAll(eventStoreService.getEvents());
		
		ListIterator<Event> iter = events.listIterator();
		
		assertEquals("type_01",iter.next().type());
		assertEquals("type_02",iter.next().type());
    	
	}

	/*
	@Test
	void testRemoveAll() {
		fail("Not yet implemented");
	}

	@Test
	void testQuery() {
		fail("Not yet implemented");
	}
	*/

}
