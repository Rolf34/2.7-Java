package company.empoloyees;

import company.structure.Department;
import company.structure.Position;
import company.structure.WorkSchedule;

public class RegularEmployee extends Employee {
    public RegularEmployee(String employeeId, String firstName, String lastName, String email,
                           String phoneNumber, Department department, Position position,
                           String hireDate, double salary, WorkSchedule workSchedule) {
        super(employeeId, firstName, lastName, email, phoneNumber, department, position, hireDate, salary, workSchedule);
    }

    @Override
    public String getRole() { return "Regular"; }

    @Override
    public void performDuties() { System.out.println(getFullName() + " performs regular duties"); }

    @Override
    public String getContactSummary() { return getEmail() + " / " + getPhoneNumber(); }
}
