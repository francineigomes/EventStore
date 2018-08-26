package net.intelie.challenges;


import java.util.List;
import java.util.ListIterator;

public class EventIteratorService implements EventIterator {

	
	public EventIteratorService(List<Event> events) {
		super();
		this.events = events;
		iter = this.events.listIterator();
	}

	private List<Event> events;
	private ListIterator<Event> iter;
	private boolean control = false;
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean moveNext() {
		// TODO Auto-generated method stub
		if(iter.hasNext()) {
			iter.next();
			setControl(true);
			System.out.println("Final list size from moveNext(): " + events.size());
			return true;
		}else {
			setControl(false);
			System.out.println("Final list size from moveNext(): " + events.size());
			return false;}
		}

	@Override
	public Event current() {
		// TODO Auto-generated method stub
		if(!getControl()) {
			throw new IllegalStateException("Exception from current method");
		}
		return iter.next();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		if(!getControl()) {
			throw new IllegalStateException("Exception from remove method");
		}
		iter.remove();
		iter.next();
		//events.remove(current());
		System.out.println("Final list size from remove(): " + events.size());
	}

	public boolean getControl() {
		return control;
	}

	public void setControl(boolean control) {
		this.control = control;
	}

}
