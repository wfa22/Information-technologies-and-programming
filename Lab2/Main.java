public class Main {
    public static void main(String[] args) {
        Administrator admin = new Administrator("Alice", 30, 50000, "IT");
        Programmer programmer = new Programmer("Bob", 25, 70000, "Java");
        Manager manager = new Manager("Charlie", 35, 80000, "General", 10);

        admin.work();
        System.out.println("=============");
        programmer.work();
        System.out.println("=============");
        manager.work();
        System.out.println("=============");

        admin.displayInformation();
        System.out.println("=============");
        programmer.displayInformation();
        System.out.println("=============");
        manager.displayInformation();
        System.out.println("=============");
        System.out.println("=============");
        System.out.println("=============");


        Manager defaultManager = new Manager();
        defaultManager.work();
        System.out.println("=============");
        defaultManager.displayInformation();
        System.out.println("=============");

        System.out.println("Total Employees: " + Employee.getEmployeeCount());
    }
}
