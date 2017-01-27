package lv.rtu.repositories;

import lv.rtu.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClientEntityRepository extends CrudRepository<ClientEntity, Long> {
}
