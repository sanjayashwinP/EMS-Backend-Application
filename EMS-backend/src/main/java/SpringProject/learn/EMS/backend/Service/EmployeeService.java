package SpringProject.learn.EMS.backend.Service;

import SpringProject.learn.EMS.backend.Exception.ResourceNotFoundException;
import SpringProject.learn.EMS.backend.Model.Employee;
import SpringProject.learn.EMS.backend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id : " + id));
    }

    public void updateEmployee(Employee employee,Long id) {
        Employee employees = getEmployeeById(id);
        employees.setFirstName(employee.getFirstName());
        employees.setLastName(employee.getLastName());
        employees.setEmail(employee.getEmail());
        employeeRepository.save(employees);
    }

    public void deleteemployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
