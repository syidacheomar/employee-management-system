import java.util.Scanner;

class Employee{
    private String name;
    private double baseSalary;
    private double healthAllowance;
    private double transportAllowance;
    private double bonus;
    private double totalSalary;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        this.healthAllowance = 0.0;
        this.transportAllowance = 0.0;
        this.bonus = 0.0;
    }

    public String getName(){
        return name;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public double getHealthAllowance(){
        return healthAllowance;
    }

    public double getTransportAllowance(){
        return transportAllowance;
    }

    public void setHealthAllowance(double healthAllowance){
        this.healthAllowance = healthAllowance;
    }

    public void setTransportAllowance(double transportAllowance){
        this.transportAllowance = transportAllowance;
    }

    public double assignBonus(){

        if(baseSalary > 50000){
            bonus = 0.10*baseSalary;
        }
        
        if(baseSalary >=30000 && baseSalary <= 50000){
            bonus = 0.05*baseSalary;
        }
        if(baseSalary <30000){
            bonus = 0.00*baseSalary;
        }
        return bonus;

    }

    public double calculateTotalSalary(){

       totalSalary= baseSalary + healthAllowance + transportAllowance + assignBonus();
       return totalSalary;
    }

    public void displayEmployeeDetails(){
        System.out.println("Employee Name:" + " " + getName());
        System.out.println("Base Salary:" + " " + "RM" + " " + baseSalary);
        System.out.println("Health Allowance:" + " " + "RM" + " " + healthAllowance);
        System.out.println("Transport Allowance:" + " " + "RM" + " " + transportAllowance);
        System.out.println("Total Salary:" + " " + "RM" + " " + calculateTotalSalary());
        System.out.println();
    }
    

}

public class EmployeeManagementSystem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[3];

        for(int i = 0; i<employees.length; i++){
            
            System.out.println("Name:");
            String name = scanner.nextLine();

            System.out.println("Base Salary:");
            double baseSalary = scanner.nextDouble();

            System.out.println("Health allowance:");
            double healthAllowance = scanner.nextDouble();

            System.out.println("Transport allowance:");
            double transportAllowance = scanner.nextDouble();

            scanner.nextLine();

            employees[i] = new Employee(name, baseSalary);
            employees[i].setHealthAllowance(healthAllowance);
            employees[i].setTransportAllowance(transportAllowance);
            
        }

        for(Employee employee:employees){
            employee.displayEmployeeDetails();
            System.out.println("");
        }

        scanner.close();
    }
}