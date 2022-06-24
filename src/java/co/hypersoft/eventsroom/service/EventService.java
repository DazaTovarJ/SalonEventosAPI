/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.service;

import co.hypersoft.eventsroom.models.Event;
import co.hypersoft.eventsroom.models.EventAccessor;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            return accessor.getEvent(eventId);
        } catch (SQLException ex) {
            System.out.println("Couldn't find event");
            return null;
        }
    }

    public Event addEvent(Event evt) {
        try {
            accessor.add(evt);

            return evt;
        } catch (SQLException ex) {
            System.out.println("Coudn't add the event");
            return null;
        }
    }

    public Event updateEvent(Event evt) {
        try {
            accessor.update(evt);
            return evt;
        } catch (SQLException e) {
            System.out.println("Couldn't update the event");
            return null;
        }
    }

    public String deleteEvent(long eventId) {
        try {
            accessor.delete(eventId);
            return "Event deleted";
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return "Couldn't delete event";
        }
    }
}