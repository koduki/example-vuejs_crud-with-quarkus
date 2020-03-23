package crud;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author koduki
 */
@ApplicationScoped
public class ItemRepository implements PanacheRepository<Item> {

    public Item findById(UUID id) {
        return this.find("id", id).list().get(0);
    }

    public void update(UUID id, Item item) {
        var x = findById(id);
        x.setName(item.getName());
        x.setPrice(item.getPrice());
    }
}
