package course6.Exercitiul1;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private static List<User> users = new ArrayList<>();
    // Metoda pentru obținerea tuturor utilizatorilor
    @GET
    public Response getUsers() {
        return Response.ok(users).build();
    }
    // Metoda pentru obținerea unui utilizator după ID
    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") int id) {
        if (id < 0 || id >= users.size()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        User user = users.get(id);
        return Response.ok(user).build();
    }
    @GET
    @Path("/search")
    public Response searchUsersByName(@QueryParam("name") String name) {
        List<User> matchedUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getName().equals(name)) {
                matchedUsers.add(user);
            }
        }
        return Response.ok(matchedUsers).build();
    }


    // Metoda pentru adăugarea unui nou utilizator
    @POST
    public Response addUser(@Valid User user) {
        users.add(user);
        return Response.status(Response.Status.CREATED).build();
    }
    // Metoda pentru actualizarea unui utilizator existent
    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") int id, @Valid User updatedUser) {
        if (id < 0 || id >= users.size()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        users.set(id, updatedUser);
        return Response.noContent().build();
    }
    // Metoda pentru ștergerea unui utilizator
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        if (id < 0 || id >= users.size()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        users.remove(id);
        return Response.noContent().build();
    }
}
