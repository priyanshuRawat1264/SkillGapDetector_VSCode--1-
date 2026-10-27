import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Main extends JFrame {
    private final JComboBox<String> professionBox;
    private final JTextField skillsField;
    private final DefaultTableModel tableModel;
    private final JLabel summaryLabel;
    private final List<Profession> professions = CareerData.getProfessions();
    private final SkillGapAnalyzer analyzer = new SkillGapAnalyzer();

    private static final Color BACKGROUND = new Color(15, 23, 42);
    private static final Color PANEL = new Color(30, 41, 59);
    private static final Color BLUE = new Color(59, 130, 246);
    private static final Color TEXT = new Color(226, 232, 240);

    public Main() {
        setTitle("Skill Gap Detector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 680);
        setMinimumSize(new Dimension(760, 580));
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout(0, 18));
        root.setBackground(BACKGROUND);
        root.setBorder(BorderFactory.createEmptyBorder(22, 24, 24, 24));
        setContentPane(root);

        JPanel header = new JPanel(new BorderLayout(8, 6));
        header.setBackground(BACKGROUND);

        JLabel title = new JLabel("SKILL GAP DETECTOR");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));

        JLabel subtitle = new JLabel(
                "Compare your current skills with the requirements of your target career.");
        subtitle.setForeground(new Color(148, 163, 184));
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JPanel headingText = new JPanel(new GridLayout(2, 1, 0, 6));
        headingText.setOpaque(false);
        headingText.add(title);
        headingText.add(subtitle);
        header.add(headingText, BorderLayout.CENTER);
        root.add(header, BorderLayout.NORTH);

        JPanel mainContent = new JPanel(new BorderLayout(0, 16));
        mainContent.setOpaque(false);
        root.add(mainContent, BorderLayout.CENTER);

        JPanel inputs = new JPanel(new GridBagLayout());
        inputs.setBackground(PANEL);
        inputs.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(51, 65, 85)),
                BorderFactory.createEmptyBorder(18, 20, 18, 20)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 7, 0);

        JLabel professionLabel = createLabel("TARGET PROFESSION");
        gbc.gridy = 0;
        inputs.add(professionLabel, gbc);

        String[] careerNames = professions.stream()
                .map(Profession::getName).toArray(String[]::new);
        professionBox = new JComboBox<>(careerNames);
        professionBox.setEditable(true);
        professionBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridy = 1;
        inputs.add(professionBox, gbc);

        JLabel skillsLabel = createLabel("YOUR CURRENT SKILLS (SEPARATE WITH COMMAS)");
        gbc.gridy = 2;
        gbc.insets = new Insets(12, 0, 7, 0);
        inputs.add(skillsLabel, gbc);

        skillsField = new JTextField();
        skillsField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        skillsField.setToolTipText("Example: Java, OOP, SQL");
        skillsField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(71, 85, 105)),
                BorderFactory.createEmptyBorder(9, 10, 9, 10)));
        gbc.gridy = 3;
        gbc.insets = new Insets(5, 0, 10, 0);
        inputs.add(skillsField, gbc);

        JButton analyzeButton = new JButton("Analyze My Skills");
        analyzeButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        analyzeButton.setForeground(Color.WHITE);
        analyzeButton.setBackground(BLUE);
        analyzeButton.setFocusPainted(false);
        analyzeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        analyzeButton.addActionListener(e -> analyzeSkills());
        gbc.gridy = 4;
        gbc.insets = new Insets(5, 0, 0, 0);
        inputs.add(analyzeButton, gbc);
        mainContent.add(inputs, BorderLayout.NORTH);

        JPanel results = new JPanel(new BorderLayout(0, 12));
        results.setOpaque(false);

        JLabel resultTitle = new JLabel("SKILL COMPARISON RESULTS");
        resultTitle.setForeground(Color.WHITE);
        resultTitle.setFont(new Font("SansSerif", Font.BOLD, 18));

        tableModel = new DefaultTableModel(new Object[]{"Required Skill", "Your Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.setRowHeight(34);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setForeground(TEXT);
        table.setBackground(new Color(23, 37, 61));
        table.setGridColor(new Color(51, 65, 85));
        table.setShowVerticalLines(false);
        table.setSelectionBackground(new Color(51, 65, 85));
        table.setSelectionForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        table.getTableHeader().setBackground(new Color(51, 65, 85));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setReorderingAllowed(false);

        DefaultTableCellRenderer statusRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tbl, Object value,
                    boolean selected, boolean focused, int row, int column) {
                super.getTableCellRendererComponent(tbl, value, selected, focused, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                setFont(new Font("SansSerif", Font.BOLD, 13));
                if (!selected) {
                    setBackground(new Color(23, 37, 61));
                    setForeground(value != null && value.toString().startsWith("✓")
                            ? new Color(74, 222, 128) : new Color(248, 113, 113));
                }
                return this;
            }
        };
        table.getColumnModel().getColumn(1).setCellRenderer(statusRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(23, 37, 61));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(51, 65, 85)));

        summaryLabel = new JLabel("Choose a profession, enter your skills, and click Analyze.");
        summaryLabel.setForeground(new Color(148, 163, 184));
        summaryLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        summaryLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));

        results.add(resultTitle, BorderLayout.NORTH);
        results.add(scrollPane, BorderLayout.CENTER);
        results.add(summaryLabel, BorderLayout.SOUTH);
        mainContent.add(results, BorderLayout.CENTER);

        analyzeSkills();
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(203, 213, 225));
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        return label;
    }

    private void analyzeSkills() {
        Object editorValue = professionBox.getEditor().getItem();
        String selectedCareer = editorValue == null ? "" : editorValue.toString().trim();

        Profession selectedProfession = null;
        for (Profession profession : professions) {
            if (profession.getName().equalsIgnoreCase(selectedCareer)) {
                selectedProfession = profession;
                break;
            }
        }

        if (selectedProfession == null) {
            JOptionPane.showMessageDialog(this,
                    "This profession is not in the current career library.\n"
                    + "Add its required skills to CareerData.java first.",
                    "Profession Not Found", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<SkillGapAnalyzer.SkillResult> results =
                analyzer.analyze(selectedProfession, skillsField.getText());

        tableModel.setRowCount(0);
        int have = 0;
        int missing = 0;

        for (SkillGapAnalyzer.SkillResult result : results) {
            String status;
            if (result.isAvailable()) {
                status = "\u2713 Have";
                have++;
            } else {
                status = "\u2717 Missing";
                missing++;
            }
            tableModel.addRow(new Object[]{result.getSkill(), status});
        }

        int match = results.isEmpty() ? 0 : have * 100 / results.size();
        summaryLabel.setText("Skills you have: " + have
                + "     |     Skills missing: " + missing
                + "     |     Skills match: " + match + "%");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}
