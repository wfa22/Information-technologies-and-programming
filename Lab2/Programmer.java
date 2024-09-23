public class Programmer extends Employee {
    private String programmingLanguage;

    public Programmer(String name, int age, double salary, String programmingLanguage) {
        super(name, age, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public Programmer() {
        this("NoName", 0, 0, "Ignorant");
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println("This programmer is " + programmingLanguage + " developer.");
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Programming language: " + programmingLanguage);
    }


}