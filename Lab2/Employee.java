public abstract class Employee {
    private String name;
    private int age;
    private double salary;
    public static int employeeCount = 0;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        employeeCount++;
    }

    public Employee() {
        this("NoName", 0, 0);
        employeeCount++;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayInformation() {
        System.out.println("Name: " + name + "\nAge: " + age + "\nSalary: " + salary);
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

}