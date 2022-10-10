package dev.nklab.nornir;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author koduki
 */
@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class ItemResource {

    @Inject
    ItemRepository repository;

    @GET
    @Path("{id}")
    public Item get(@PathParam("id") UUID id) {
        return repository.findById(id);
    }

    @GET
    public List<Item> list() {
        return repository.listAll();
    }

    @POST
    public Map<String, String> create(Item item) {
        repository.persist(item);
        return Map.of("status", "OK");
    }

    @PUT
    @Path("{id}")
    public Map<String, String> update(@PathParam("id") UUID id, Item item) {
        repository.update(id, item);
        return Map.of("status", "OK");
    }

    @DELETE
    @Path("{id}")
    public Map<String, String> delete(@PathParam("id") UUID id) {
        repository.delete("id", id);
        return Map.of("status", "OK");
    }
}
