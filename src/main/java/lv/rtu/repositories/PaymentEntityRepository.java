package lv.rtu.repositories;

import lv.rtu.entities.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PaymentEntityRepository extends CrudRepository<PaymentEntity, Long> {
}
