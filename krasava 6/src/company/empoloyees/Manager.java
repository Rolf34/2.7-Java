package company.empoloyees;

import company.structure.Department;
import company.structure.Position;
import company.structure.WorkSchedule;

public class Manager extends Employee {
    private Department managedDepartment;
    
    public Manager(String employeeId, String firstName, String lastName, 
                  String email, String phoneNumber, Department department, 
                  Position position, String hireDate, double salary, 
                  WorkSchedule workSchedule, boolean isActive, 
                  Department managedDepartment) {
        super(employeeId, firstName, lastName, email, phoneNumber, 
              department, position, hireDate, salary, workSchedule, isActive);
        this.managedDepartment = managedDepartment;
    }

    public Department getManagedDepartment() {
        return managedDepartment;
    }

    @Override
    public String getRole() { return "Manager"; }

    @Override
    public void performDuties() { System.out.println(getFullName() + " manages department " + (managedDepartment != null ? managedDepartment.getName() : "(none)")); }

    @Override
    public String getContactSummary() { return getEmail() + " / " + getPhoneNumber(); }
}
