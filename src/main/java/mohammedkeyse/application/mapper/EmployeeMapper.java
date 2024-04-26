package mohammedkeyse.application.mapper;

import mohammedkeyse.application.dto.EmployeeDto;
import mohammedkeyse.application.entity.Employee;

public class EmployeeMapper {


    // Metode for å konvertere Employee-objektet til EmployeeDTO Objektet
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail()
        );
    }



    // Metode for å konvertere EMployeeDto-objektet tilbake til Employee-objektet
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail()
        );
    }
}
