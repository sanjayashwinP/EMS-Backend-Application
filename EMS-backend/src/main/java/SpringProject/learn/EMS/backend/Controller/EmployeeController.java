package SpringProject.learn.EMS.backend.Controller;

import SpringProject.learn.EMS.backend.Model.Employee;
import SpringProject.learn.EMS.backend.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getallEmployees")
    public List<Employee> getEmployee(){
        return employeeService.getEmployees();
    }
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable Long id) {
        employeeService.updateEmployee(employee,id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteemployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
