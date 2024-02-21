package course6.Exercitiul2;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private static List<Product> products = new ArrayList<>();

    @GET
    public Response getProducts() {
        return Response.ok(products).build();
    }
    @POST
    public Response addProduct(@Valid Product product) {
        products.add(product);
        return Response.status(Response.Status.CREATED).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") int id, @Valid Product updatedProduct) {
        if (id < 0 || id >= products.size()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        products.set(id, updatedProduct);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        if (id < 0 || id >= products.size()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        products.remove(id);
        return Response.noContent().build();
    }
}
