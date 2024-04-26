package mohammedkeyse.application.service;

import mohammedkeyse.application.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee (EmployeeDto employeeDto);

    EmployeeDto getEmployeeById (long employeeId);
}
