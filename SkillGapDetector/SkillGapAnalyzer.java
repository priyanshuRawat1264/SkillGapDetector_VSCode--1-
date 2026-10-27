import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SkillGapAnalyzer {
    public static class SkillResult {
        private final String skill;
        private final boolean available;

        public SkillResult(String skill, boolean available) {
            this.skill = skill;
            this.available = available;
        }

        public String getSkill() {
            return skill;
        }

        public boolean isAvailable() {
            return available;
        }
    }

    public List<SkillResult> analyze(Profession profession, String currentSkillsText) {
        Set<String> currentSkills = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        for (String skill : currentSkillsText.split(",")) {
            if (!skill.trim().isEmpty()) {
                currentSkills.add(skill.trim());
            }
        }

        List<SkillResult> results = new ArrayList<>();
        for (String requiredSkill : profession.getRequiredSkills()) {
            results.add(new SkillResult(
                    requiredSkill, currentSkills.contains(requiredSkill)));
        }
        return results;
    }
}
