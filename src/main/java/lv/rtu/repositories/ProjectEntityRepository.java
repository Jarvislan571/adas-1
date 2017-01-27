package lv.rtu.repositories;

import lv.rtu.entities.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProjectEntityRepository extends CrudRepository<ProjectEntity, Long> {
}
