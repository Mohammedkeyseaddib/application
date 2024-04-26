package mohammedkeyse.application;

import mohammedkeyse.application.dto.EmployeeDto;
import mohammedkeyse.application.entity.Employee;
import mohammedkeyse.application.repository.EmployeeRepository;
import mohammedkeyse.application.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class ApplicationTests {

    @Mock  // vi må mocke repositoriet siden Employeeservice avhenger av det for databasetilgangen
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();


    @Test
    void testCreateEmployee() {

        // Arrange

        EmployeeDto inputDto = new EmployeeDto(null, "Jane" , "Doe", "Jane.doe@example.com" );
        Employee employee = new Employee(null, "Jane" , "Doe", "Jane.doe@example.com" );
        Employee savedEmployee = new Employee (1L, "Jane" , "Doe", "Jane.doe@example.com");
        EmployeeDto expectedDto = new EmployeeDto(1L, "Jane" , "Doe", "Jane.doe@example.com");


        // Act

        when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

        EmployeeDto result = employeeService.createEmployee(inputDto);



        // Assert

        assertEquals(expectedDto.getId(), result.getId());
        assertEquals(expectedDto.getFirstname(), result.getFirstname());
        assertEquals(expectedDto.getLastname(), result.getLastname());
        assertEquals(expectedDto.getEmail(), result.getEmail());

    }

}
