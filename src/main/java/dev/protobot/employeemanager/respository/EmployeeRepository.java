package dev.protobot.employeemanager.respository;

import dev.protobot.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    String queryListAllEmployees =
            "SELECT * FROM Employee;";
    @Query(value = queryListAllEmployees, nativeQuery = true)
    List<Employee> getAllEmployees();


    String queryGetEmployeeById =
            "SELECT * FROM Employee WHERE id = :id ;";
    @Query(value = queryGetEmployeeById, nativeQuery = true)
    Optional<Employee> getEmployeesById(
            @Param("id") Long id);


    String queryAddEmployee =
            "INSERT INTO Employee (name, email, jobTitle, phone, employeeCode) " +
            "VALUES( :name, :email, :jobTitle, :phone, :employeeCode) RETURNING *;";
    @Query(value = queryAddEmployee, nativeQuery = true)
    Employee saveEmployee(
            @Param("name") String name,
            @Param("email") String email,
            @Param("jobTitle") String jobTitle,
            @Param("phone") String phone,
            @Param("employeeCode") String employeeCode);

    String queryUpdateEmployee =
            "UPDATE Employee SET " +
                    "name = :name , " +
                    "email = :email , " +
                    "jobTitle = :jobTitle , " +
                    "phone = :phone  " +
                    "WHERE id = :id " +
                    "RETURNING * ;";
    @Query(value = queryUpdateEmployee, nativeQuery = true)
    Employee updateEmployee(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("email") String email,
            @Param("jobTitle") String jobTitle,
            @Param("phone") String phone);

    String queryDeleteEmployeeById =
            "DELETE FROM Employee WHERE id = :id RETURNING NULL ;";
    @Query(value = queryDeleteEmployeeById, nativeQuery = true)
    void deleteEmployeeById(
            @Param("id") Long id);

}
