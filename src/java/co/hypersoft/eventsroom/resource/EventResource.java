/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.resource;

import co.hypersoft.eventsroom.models.Event;
import co.hypersoft.eventsroom.service.EventService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author jdaza
 */
@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

    EventService service = new EventService();

    @GET
    public List<Event> getEvents() {
        return service.getEvents();
    }

    @GET
    @Path("/{eventId}")
    public Event getEvent(@PathParam("eventId") long eventId) {
        return service.getEvent(eventId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Event addEvent(Event evt) {
        return service.addEvent(evt);
    }

    @PUT
    @Path("/{eventId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Event updateEvent(@PathParam("eventId") long eventId, Event event) {
        event.setId(eventId);
        return service.updateEvent(event);
    }

    @DELETE
    @Path("/{eventId}")
    public String deleteArticle(@PathParam("eventId") long eventId) {
        return service.deleteEvent(eventId);
    }

}
