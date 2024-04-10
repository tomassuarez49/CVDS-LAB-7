package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(String employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> getByPartialName(String partialName) {
        return employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(partialName, partialName);
    }
}
