/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.resource;

import co.hypersoft.eventsroom.models.Event;
import co.hypersoft.eventsroom.models.Message;
import co.hypersoft.eventsroom.service.EventService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
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
    public Response getEvents() {
        List<Event> events = service.getEvents();
        if (events == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new Message(400, "Couldn't get the data"))
                    .build();
        }

        if (events.isEmpty()) {
            return Response.noContent()
                    .entity(new Message(204, "There are no events registered"))
                    .build();
        }

        return Response.ok(new Message(200, "Events found", events)).build();
    }

    @GET
    @Path("/{eventId}")
    public Event getEvent(@PathParam("eventId") long eventId) {
        return service.getEvent(eventId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEvent(Event evt, @Context UriInfo uriInfo) {
        Event newEvent = service.addEvent(evt);
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path(String.valueOf(evt.getId()))
                .build(newEvent.getId());

        return Response.created(uri)
                .entity(new Message(200, "Event added", newEvent))
                .build();
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
