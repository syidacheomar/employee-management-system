class Employee {
    constructor(name, baseSalary, healthAllowance, transportAllowance) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.healthAllowance = healthAllowance;
        this.transportAllowance = transportAllowance;
        this.bonus = this.assignBonus();
        this.totalSalary = this.calculateTotalSalary();
    }

    assignBonus() {
        if (this.baseSalary > 50000) {
            return 0.10 * this.baseSalary;
        } else if (this.baseSalary >= 30000 && this.baseSalary <= 50000) {
            return 0.05 * this.baseSalary;
        } else {
            return 0.00;
        }
    }

    calculateTotalSalary() {
        return this.baseSalary + this.healthAllowance + this.transportAllowance + this.bonus;
    }

    displayEmployeeDetails() {
        return `
            <div>
                <p>Employee Name: ${this.name}</p>
                <p>Base Salary: RM ${this.baseSalary}</p>
                <p>Health Allowance: RM ${this.healthAllowance}</p>
                <p>Transport Allowance: RM ${this.transportAllowance}</p>
                <p>Total Salary: RM ${this.totalSalary}</p>
            </div>
        `;
    }
}

const employees = [];

function addEmployee() {
    const name = document.getElementById('name').value;
    const baseSalary = parseFloat(document.getElementById('baseSalary').value);
    const healthAllowance = parseFloat(document.getElementById('healthAllowance').value);
    const transportAllowance = parseFloat(document.getElementById('transportAllowance').value);

    const employee = new Employee(name, baseSalary, healthAllowance, transportAllowance);
    employees.push(employee);

    displayEmployees();
}

function displayEmployees() {
    const employeeDetails = document.getElementById('employeeDetails');
    employeeDetails.innerHTML = employees.map(employee => employee.displayEmployeeDetails()).join('');
}
