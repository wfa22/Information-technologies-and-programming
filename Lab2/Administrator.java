public class Administrator extends Employee {
    protected String department;

    public Administrator(String name, int age, double salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    public Administrator() {
        this("NoName", 0, 0, "NoDepartment");
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void work() {
        System.out.println("Administrator works in department " + department);
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Department : " + department);
    }


}