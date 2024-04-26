package mohammedkeyse.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mohammedkeyse.application.dto.EmployeeDto;
import mohammedkeyse.application.entity.Employee;
import mohammedkeyse.application.exception.ResourceNotFoundException;
import mohammedkeyse.application.mapper.EmployeeMapper;
import mohammedkeyse.application.repository.EmployeeRepository;
import mohammedkeyse.application.service.EmployeeService;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=  employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
