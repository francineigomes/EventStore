package net.intelie.challenges;

import java.util.NoSuchElementException;

public class EventStoreApplication {

	/**
	 * @param args
	 */
	    public static void main(String[] args) {

	    	// Memory allocation
		EventStore eventStoreService = new EventStoreService();

	    	// Creating events
	    	Event event_01 = new Event("type_01", 123L);
	    	Event event_02 = new Event("type_02", 223L);
	    	Event event_03 = new Event("type_02", 323L);
	    	Event event_04 = new Event("type_03", 423L);
	    	Event event_05 = new Event("type_04", 523L);
	    	Event event_06 = new Event("type_05", 623L);
	    	Event event_07 = new Event("type_05", 723L);
	    	Event event_08 = new Event("type_05", 823L);
	    	Event event_09 = new Event("type_05", 923L);

		// Insert event
		eventStoreService.insert(event_01);
		eventStoreService.insert(event_02);
		eventStoreService.insert(event_03);
		eventStoreService.insert(event_04);
		eventStoreService.insert(event_05);
		eventStoreService.insert(event_06);
		eventStoreService.insert(event_07);
		eventStoreService.insert(event_08);
		eventStoreService.insert(event_09);

		// Removing event
		eventStoreService.removeAll("type_02");

		// Get subList
		EventIterator iterSubList = eventStoreService.query("type_05", 623L, 923L);

		try {
			iterSubList.moveNext();
			//iterSubList.moveNext();
			//iterSubList.moveNext();
			//iterSubList.remove();
			//iterSubList.remove();
		}
		catch (IllegalStateException ex) {
			System.out.println(ex.getMessage());
		}				

		try {				
			iterSubList.moveNext();
			Event currentEvent = iterSubList.current();
			System.out.println("Current event : " + currentEvent.type() + ", timestamp: "+ currentEvent.timestamp()+ " to subList");

			currentEvent = iterSubList.current();
			System.out.println("Current event : " + currentEvent.type() + ", timestamp: "+ currentEvent.timestamp()+ " to subList");

		}
		catch (IllegalStateException ex) {
			System.out.println(ex.getMessage());
		}
		catch (NoSuchElementException ex) {
			System.out.println("The iterador reached the end of Sublist");
		}					
	    }
}
