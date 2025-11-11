package EmployeeDepartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    private int id;
    private String name;
    private String department;
    private double salary;

}
