package org.jveda.demos.jaxrs20;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/greet")
public class GreetService {

  @GET
  @Produces("text/plain")
  public Response doGet() throws InterruptedException {
    Thread.sleep((long)(Math.random() * 6000)); //To simulate delay!
    return Response.ok("Hi..").build();
  }
}
