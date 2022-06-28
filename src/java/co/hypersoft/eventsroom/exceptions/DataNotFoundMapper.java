/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.exceptions;

import co.hypersoft.eventsroom.models.Message;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 *
 * @author jdaza
 */
@Provider
public class DataNotFoundMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException e) {
        Message errorMessage
                = new Message(404, "Not Found",
                        "The requested event was not found");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }

}
