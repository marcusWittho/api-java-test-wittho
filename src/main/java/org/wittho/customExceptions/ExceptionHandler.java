package org.wittho.customExceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<RequiredField> {

  @Override
  public Response toResponse(RequiredField exception) {
    var errorMessage = exception.getMessage();
    var error = new Error(errorMessage);
    
    return Response.status(400).entity(error).build();
  }
}
