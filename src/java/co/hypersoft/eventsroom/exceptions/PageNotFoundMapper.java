/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.exceptions;

import co.hypersoft.eventsroom.models.Message;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 *
 * @author jdaza
 */
@Provider
public class PageNotFoundMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException e) {
        Message errorMessage = new Message(500, e.getMessage());

        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }

}
