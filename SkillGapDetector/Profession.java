import java.util.List;

public class Profession {
    private final String name;
    private final List<String> requiredSkills;

    public Profession(String name, List<String> requiredSkills) {
        this.name = name;
        this.requiredSkills = requiredSkills;
    }

    public String getName() {
        return name;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }
}
