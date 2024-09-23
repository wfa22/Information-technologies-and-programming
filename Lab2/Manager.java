public class Manager extends Administrator {
    private int teamSize;

    public Manager(String name, int age, double salary, String department, int teamSize) {
        super(name, age, salary, department);
        this.teamSize = teamSize;
    }

    public Manager() {
        this("NoName", 0, 0, "NoDepartment", 0);
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        System.out.println("Manager works in department " + department);
        System.out.println("Manager oversees a team of " + teamSize + " people.");
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Team Size: " + teamSize);
    }

}