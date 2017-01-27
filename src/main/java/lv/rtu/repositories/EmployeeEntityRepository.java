package lv.rtu.repositories;

import lv.rtu.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeEntityRepository extends CrudRepository<EmployeeEntity, Long> {
}
