/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.service;

import co.hypersoft.eventsroom.exceptions.DataNotFoundException;
import co.hypersoft.eventsroom.models.Event;
import co.hypersoft.eventsroom.models.EventAccessor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jdaza
 */
public class EventService {

    EventAccessor accessor = new EventAccessor();

    public List<Event> getEvents() {
        try {
            return accessor.getEvents();
        } catch (SQLException ex) {
            System.out.println("Couldn't find events");
            return null;
        }
    }

    public Event getEvent(long eventId) {
        try {
            Event event = accessor.getEvent(eventId);
            if (event == null) {
                throw new DataNotFoundException("The requested event was not found");
            }

            return event;
        } catch (SQLException ex) {
            System.out.println("Couldn't find event");
            return null;
        }
    }

    public Event addEvent(Event evt) {
        try {
            evt.setId(getMax());
            if (evt.getEndTime() != null && !evt.getEndTime().toString().isEmpty()) {
                accessor.add(evt);
            } else {
                accessor.addNoEndTime(evt);
            }

            return evt;
        } catch (SQLException ex) {
            System.out.println("Coudn't add the event");
            return null;
        }
    }

    public Event updateEvent(Event evt) {
        try {
            if (accessor.getEvent(evt.getId()) == null) {
                throw new DataNotFoundException("The requested event was not found");
            }
            accessor.update(evt);
            return evt;
        } catch (SQLException e) {
            System.out.println("Couldn't update the event" + e);
            return null;
        }
    }

    public boolean deleteEvent(long eventId) {
        try {
            if (accessor.getEvent(eventId) == null) {
                throw new DataNotFoundException("The requested event was not found");
            }
            accessor.delete(eventId);
            return true;
        } catch (SQLException ex) {
            System.out.println("Couldn't delete event");
            return false;
        }
    }

    private long getMax() {
        List<Event> events = this.getEvents();
        int size = events.size();
        if (size > 0) {
            return events.get(size - 1).getId() + 1;
        } else {
            return 1;
        }
    }
}
