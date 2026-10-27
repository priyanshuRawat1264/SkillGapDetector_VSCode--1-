SKILL GAP DETECTOR — VS CODE SETUP

Requirements:
- JDK 17 or newer
- Visual Studio Code
- Extension Pack for Java (Microsoft)

Files:
- Main.java: Swing graphical user interface
- Profession.java: Profession model class
- CareerData.java: Initial sample career/skill library
- SkillGapAnalyzer.java: Compares your current skills with required skills

Run:
1. Extract this ZIP.
2. Open the extracted SkillGapDetector folder in VS Code.
3. Open Terminal > New Terminal.
4. Run:
   javac Profession.java CareerData.java SkillGapAnalyzer.java Main.java
5. Then run:
   java -cp . Main

How to use:
- Choose a profession from the dropdown (or type an existing profession name).
- Enter skills separated by commas, e.g. Java, OOP, SQL
- Click Analyze My Skills.
- A table shows every required skill and whether you have it.

Important:
- This is the first working desktop version.
- Career data is currently stored in CareerData.java; MySQL/JDBC has not been connected yet.
- The included skill requirements are illustrative and should be reviewed for accuracy.
- Typing a new profession in the dropdown does not automatically invent its required skills.
