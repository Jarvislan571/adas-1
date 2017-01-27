package lv.rtu;

import lv.rtu.entities.*;
import lv.rtu.repositories.ClientEntityRepository;
import lv.rtu.repositories.EmployeeEntityRepository;
import lv.rtu.repositories.PaymentEntityRepository;
import lv.rtu.repositories.ProjectEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    private final ClientEntityRepository clientRepo;
    private final EmployeeEntityRepository employeeRepo;
    private final PaymentEntityRepository paymentRepo;
    private final ProjectEntityRepository projectRepo;

    @Autowired
    public Initializer(ClientEntityRepository clientRepo,
                       EmployeeEntityRepository employeeRepo,
                       PaymentEntityRepository paymentRepo,
                       ProjectEntityRepository projectRepo) {
        this.clientRepo = clientRepo;
        this.employeeRepo = employeeRepo;
        this.paymentRepo = paymentRepo;
        this.projectRepo = projectRepo;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ClientEntity client1 = ClientEntity.builder()
                .firstName("Client")
                .lastName("FirstOne")
                .address("FirstClientAddress")
                .mail("FirstClientMail@mail.com")
                .phoneNum("1337Client")
                .build();

        EmployeeEntity employee1 = EmployeeEntity.builder()
                .firstName("Employee")
                .lastName("FirstOne")
                .address("FirstEmployeeAddress")
                .mail("FirstEmployeeMail@mail.com")
                .phoneNum("1337Emploee")
                .build();

        PaymentEntity payment1 = PaymentEntity.builder()
                .taxPercentage(34L)
                .brutto(1000L)
                .netto(650L)
                .paymentDate(new Date(System.currentTimeMillis() - 10000))
                .employee(employee1)
                .build();

        ProjectEntity project1 = ProjectEntity.builder()
                .client(client1)
                .employees(Collections.singletonList(employee1))
                .description("FirstProjectOf1337Client")
                .title("FirstProj")
                .status(Statuses.NOT_STARTED)
                .build();

        clientRepo.save(client1);
        paymentRepo.save(payment1);
        employeeRepo.save(employee1);
        projectRepo.save(project1);
    }
}
