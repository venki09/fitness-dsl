package venky.project.dsl.service.exception;

import com.cerner.beadledom.json.common.model.JsonError;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

  @Override
  public Response toResponse(NotFoundException e) {
    return Response.status(Response.Status.NOT_FOUND).entity(
        JsonError.builder()
            .code(Response.Status.NOT_FOUND.getStatusCode())
            .message(e.getMessage())
            .build())
        .build();
  }
}
