package net.intelie.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class EventStoreService implements EventStore {

	public EventStoreService() {
		super();
		// TODO Auto-generated constructor stub
		events = new ArrayList<Event>();
		sub_events = new ArrayList<Event>();	
	}
	
	private List<Event> events;
	private List<Event> sub_events;
	
	@Override
	public void insert(Event event) {
		// TODO Auto-generated method stub
		//
		events.add(event);
		System.out.println("Adding event: " + event.type() + ", timestamp: "+ event.timestamp()+" to list");
		System.out.println("List size   : " + events.size());
	}

	@Override
	public void removeAll(String type) {
		// TODO Auto-generated method stub
		// Verify empty list
		ListIterator<Event> iter = events.listIterator();
		while(iter.hasNext()){
			Event event = iter.next();
		    if(event.type().equals(type)){
		        iter.remove();
		        System.out.println("Removing event: " + event.type() + ", timestamp: "+ event.timestamp()+" from list");
		        System.out.println("New list size : " + events.size());
		    }
		}
	}

	@Override
	public EventIterator query(String type, long startTime, long endTime) {
		// TODO Auto-generated method stub
		// Semelhante ao removeAll
		// Criar um iterador local
		// Percorrer a lista
		// Remover itens

		ListIterator<Event> iter = this.events.listIterator();
		while(iter.hasNext()){
			Event event = iter.next();
			System.out.println("Getting event: " + event.type() + ", timestamp: "+ event.timestamp()+" from list");
			
		    if(event.type().equals(type) && event.timestamp()>=startTime && event.timestamp()< endTime){
		        //iter.remove();
		    	this.sub_events.add(event);
		        System.out.println("Adding event : " + event.type() + ", timestamp: "+ event.timestamp()+ " to subList");
		        System.out.println("SubList size : " + this.sub_events.size());
		    }
		}
		EventIterator iteratorSubList = new EventIteratorService(this.sub_events);
		return iteratorSubList;
	}
}
