import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CareerData {
    public static List<Profession> getProfessions() {
        List<Profession> careers = new ArrayList<>();

        careers.add(new Profession("Java Developer",
                Arrays.asList("Java", "OOP", "SQL", "Git", "REST APIs", "Spring Boot")));
        careers.add(new Profession("Data Scientist",
                Arrays.asList("Python", "Statistics", "SQL", "Machine Learning",
                        "Data Visualization", "Mathematics")));
        careers.add(new Profession("Data Analyst",
                Arrays.asList("Excel", "SQL", "Statistics", "Python", "Power BI",
                        "Data Visualization")));
        careers.add(new Profession("Web Developer",
                Arrays.asList("HTML", "CSS", "JavaScript", "Git", "Responsive Design", "APIs")));
        careers.add(new Profession("Android Developer",
                Arrays.asList("Java", "Kotlin", "OOP", "Android Studio", "APIs", "SQL")));
        careers.add(new Profession("AI/ML Engineer",
                Arrays.asList("Python", "Mathematics", "Statistics", "Machine Learning",
                        "Deep Learning", "Git")));
        careers.add(new Profession("Cybersecurity Analyst",
                Arrays.asList("Networking", "Linux", "Python", "Security Fundamentals",
                        "Risk Analysis", "Incident Response")));
        careers.add(new Profession("Cloud Engineer",
                Arrays.asList("Linux", "Networking", "Cloud Platforms", "Scripting",
                        "Security Fundamentals", "Git")));
        careers.add(new Profession("DevOps Engineer",
                Arrays.asList("Linux", "Git", "Docker", "CI/CD", "Cloud Platforms", "Scripting")));
        careers.add(new Profession("UI/UX Designer",
                Arrays.asList("Figma", "Wireframing", "Prototyping", "User Research",
                        "Visual Design", "Usability Testing")));
        careers.add(new Profession("Graphic Designer",
                Arrays.asList("Typography", "Color Theory", "Layout Design", "Photoshop",
                        "Illustrator", "Creativity")));
        careers.add(new Profession("Digital Marketer",
                Arrays.asList("SEO", "Content Marketing", "Social Media", "Analytics",
                        "Copywriting", "Advertising")));
        careers.add(new Profession("Accountant",
                Arrays.asList("Accounting Principles", "Excel", "Taxation",
                        "Financial Reporting", "Attention to Detail")));
        careers.add(new Profession("Financial Analyst",
                Arrays.asList("Excel", "Financial Modeling", "Accounting Principles",
                        "Data Analysis", "Valuation", "Communication")));
        careers.add(new Profession("Business Analyst",
                Arrays.asList("Excel", "SQL", "Requirements Analysis", "Communication",
                        "Data Visualization", "Documentation")));
        careers.add(new Profession("Product Manager",
                Arrays.asList("Product Strategy", "Communication", "User Research",
                        "Prioritization", "Data Analysis", "Project Management")));
        careers.add(new Profession("Civil Engineer",
                Arrays.asList("Structural Analysis", "AutoCAD", "Surveying",
                        "Construction Materials", "Project Management")));
        careers.add(new Profession("Mechanical Engineer",
                Arrays.asList("Engineering Mechanics", "CAD", "Thermodynamics",
                        "Materials Science", "Manufacturing")));
        careers.add(new Profession("Electrical Engineer",
                Arrays.asList("Circuit Analysis", "Electronics", "Electrical Machines",
                        "Power Systems", "MATLAB")));
        careers.add(new Profession("Teacher",
                Arrays.asList("Subject Knowledge", "Lesson Planning", "Classroom Management",
                        "Communication", "Assessment")));
        careers.add(new Profession("Doctor",
                Arrays.asList("Medical Knowledge", "Clinical Skills", "Patient Communication",
                        "Diagnosis", "Medical Ethics")));
        careers.add(new Profession("Nurse",
                Arrays.asList("Patient Care", "Clinical Skills", "Communication",
                        "First Aid", "Medical Ethics")));
        careers.add(new Profession("Lawyer",
                Arrays.asList("Legal Research", "Legal Writing", "Negotiation",
                        "Public Speaking", "Critical Thinking")));
        careers.add(new Profession("Architect",
                Arrays.asList("Architectural Design", "AutoCAD", "Revit",
                        "Building Codes", "Spatial Planning")));
        careers.add(new Profession("Psychologist",
                Arrays.asList("Psychology Knowledge", "Active Listening", "Assessment",
                        "Research Methods", "Ethics")));
        careers.add(new Profession("Content Writer",
                Arrays.asList("Writing", "Grammar", "Research", "Editing", "SEO", "Storytelling")));
        careers.add(new Profession("Video Editor",
                Arrays.asList("Video Editing", "Storytelling", "Audio Editing",
                        "Color Correction", "Motion Graphics")));
        careers.add(new Profession("HR Manager",
                Arrays.asList("Recruitment", "Communication", "Employee Relations",
                        "Conflict Resolution", "HR Policies")));
        careers.add(new Profession("Chef",
                Arrays.asList("Cooking Techniques", "Food Safety", "Menu Planning",
                        "Time Management", "Kitchen Management")));
        careers.add(new Profession("Hotel Manager",
                Arrays.asList("Customer Service", "Hospitality Operations", "Team Management",
                        "Budgeting", "Communication")));

        return careers;
    }
}
