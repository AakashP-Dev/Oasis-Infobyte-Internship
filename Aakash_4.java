import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Aakash_4 {
    public static void main(String[] args) {
        new OnlineExaminationSystem();
    }
}

class OnlineExaminationSystem extends JFrame {
    
    String currentUsername = "Aakash";
    String currentPassword = "Aakash123";

    List<Question> questionList = new ArrayList<>();
    int currentQuestionIndex = 0;
    int timeRemaining = 300; 
    Timer examTimer;

    JLabel timerLbl = new JLabel("Time: 05:00", SwingConstants.RIGHT);
    JLabel qNumLbl = new JLabel("Question 1 of 5");
    JLabel qTextLbl = new JLabel();
    JRadioButton[] optionBtns = new JRadioButton[4];
    ButtonGroup bg = new ButtonGroup();

    JLabel resultScoreLbl = new JLabel("", SwingConstants.CENTER);
    JLabel resultTimeLbl = new JLabel("", SwingConstants.CENTER);
    JTextArea breakdownArea = new JTextArea();
    
    JLabel nameAndPassword;

    OnlineExaminationSystem() {
        CardLayout cl = new CardLayout();
        JPanel mainPanel = new JPanel(cl);
        JPanel loginPage = new JPanel();
        JPanel homePage = new JPanel();
        JPanel resultPage = new JPanel();

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new GridBagLayout());
        loginPage.setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));

        JLabel loginLbl = new JLabel("Login Page");
        loginLbl.setFont(new Font("SansSerif", Font.BOLD, 26));
        topPanel.add(loginLbl);
        loginPage.add(topPanel, BorderLayout.NORTH);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("SansSerif", Font.PLAIN, 15);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 14);
        
        JLabel enterName = new JLabel("Enter User Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        enterName.setFont(labelFont);
        wrapper.add(enterName, gbc);
        
        JTextField name = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        name.setFont(inputFont);
        name.setPreferredSize(new Dimension(200, 32));
        wrapper.add(name, gbc);
        
        JLabel enterPassword = new JLabel("Enter Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        enterPassword.setFont(labelFont);
        wrapper.add(enterPassword, gbc);
        
        JPasswordField password = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        password.setFont(inputFont);
        password.setPreferredSize(new Dimension(200, 32));
        wrapper.add(password, gbc);
        
        nameAndPassword = new JLabel("User Name: " + currentUsername + ", Password: " + currentPassword, SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        nameAndPassword.setFont(new Font("SansSerif", Font.ITALIC, 13));
        nameAndPassword.setForeground(Color.GRAY);
        wrapper.add(nameAndPassword, gbc);
        
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JButton loginBtn = new JButton("Login");
        JButton clearBtn = new JButton("Clear");

        loginBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        clearBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginBtn.setPreferredSize(new Dimension(100, 35));
        clearBtn.setPreferredSize(new Dimension(100, 35));
        loginBtn.setFocusPainted(false);
        clearBtn.setFocusPainted(false);

        btnPanel.add(loginBtn);
        btnPanel.add(clearBtn);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        wrapper.add(btnPanel, gbc);

        loginPage.add(wrapper, BorderLayout.CENTER);

        clearBtn.addActionListener(e -> {
            name.setText("");
            password.setText("");
        });

        homePage.setLayout(new GridBagLayout());
        GridBagConstraints homeGbc = new GridBagConstraints();
        homeGbc.insets = new Insets(10, 10, 10, 10);
        homeGbc.fill = GridBagConstraints.HORIZONTAL;

        Font titleFont = new Font("SansSerif", Font.BOLD, 22);

        JLabel welcomeLbl = new JLabel("Welcome, " + currentUsername + "!", SwingConstants.CENTER);
        welcomeLbl.setFont(titleFont);
        homeGbc.gridx = 0;
        homeGbc.gridy = 0;
        homeGbc.gridwidth = 2;
        homePage.add(welcomeLbl, homeGbc);

        JLabel profileTitle = new JLabel("--- Update Profile ---", SwingConstants.CENTER);
        profileTitle.setFont(new Font("SansSerif", Font.ITALIC, 14));
        profileTitle.setForeground(Color.GRAY);
        homeGbc.gridx = 0;
        homeGbc.gridy = 1;
        homeGbc.gridwidth = 2;
        homePage.add(profileTitle, homeGbc);

        JLabel nameLbl = new JLabel("Display Name:");
        nameLbl.setFont(labelFont);
        homeGbc.gridx = 0;
        homeGbc.gridy = 2;
        homeGbc.gridwidth = 1;
        homePage.add(nameLbl, homeGbc);

        JTextField newNameTxt = new JTextField(currentUsername, 15);
        newNameTxt.setFont(inputFont);
        newNameTxt.setPreferredSize(new Dimension(200, 32));
        homeGbc.gridx = 1;
        homeGbc.gridy = 2;
        homeGbc.gridwidth = 1;
        homePage.add(newNameTxt, homeGbc);

        JLabel passLbl = new JLabel("New Password:");
        passLbl.setFont(labelFont);
        homeGbc.gridx = 0;
        homeGbc.gridy = 3;
        homeGbc.gridwidth = 1;
        homePage.add(passLbl, homeGbc);

        JPasswordField newPassTxt = new JPasswordField(currentPassword, 15);
        newPassTxt.setFont(inputFont);
        newPassTxt.setPreferredSize(new Dimension(200, 32));
        homeGbc.gridx = 1;
        homeGbc.gridy = 3;
        homeGbc.gridwidth = 1;
        homePage.add(newPassTxt, homeGbc);

        JPanel homeBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JButton updateBtn = new JButton("Update Profile");
        JButton startBtn = new JButton("Start Exam");

        updateBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        startBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        updateBtn.setPreferredSize(new Dimension(140, 35));
        startBtn.setPreferredSize(new Dimension(130, 35));
        updateBtn.setFocusPainted(false);
        startBtn.setFocusPainted(false);

        homeBtnPanel.add(updateBtn);
        homeBtnPanel.add(startBtn);

        homeGbc.gridx = 0;
        homeGbc.gridy = 4;
        homeGbc.gridwidth = 2;
        homePage.add(homeBtnPanel, homeGbc);

        questionList.add(new Question("1. What is the default value of a boolean variable in Java?", new String[]{"true", "false", "null", "0"}, 1));
        questionList.add(new Question("2. Which keyword is used to declare a constant in Java?", new String[]{"static", "const", "final", "abstract"}, 2));
        questionList.add(new Question("3. Which package contains the Swing GUI components?", new String[]{"java.awt", "javax.swing", "java.io", "java.util"}, 1));
        questionList.add(new Question("4. What layout manager displays components in a grid of cards?", new String[]{"BorderLayout", "GridLayout", "GridBagLayout", "CardLayout"}, 3));
        questionList.add(new Question("5. Which method displays a CardLayout card?", new String[]{"show()", "display()", "setVisible()", "switch()"}, 0));

        JPanel examPanel = new JPanel(new BorderLayout(15, 15));
        examPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel topExamPanel = new JPanel(new BorderLayout());
        qNumLbl.setFont(new Font("SansSerif", Font.BOLD, 16));
        timerLbl.setFont(new Font("SansSerif", Font.BOLD, 16));
        timerLbl.setForeground(Color.RED);
        topExamPanel.add(qNumLbl, BorderLayout.WEST);
        topExamPanel.add(timerLbl, BorderLayout.EAST);
        examPanel.add(topExamPanel, BorderLayout.NORTH);

        JPanel centerExamPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        qTextLbl.setFont(new Font("SansSerif", Font.BOLD, 15));
        centerExamPanel.add(qTextLbl);

        for (int i = 0; i < 4; i++) {
            optionBtns[i] = new JRadioButton();
            optionBtns[i].setFont(new Font("SansSerif", Font.PLAIN, 14));
            bg.add(optionBtns[i]);
            centerExamPanel.add(optionBtns[i]);
        }
        examPanel.add(centerExamPanel, BorderLayout.CENTER);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        JButton prevBtn = new JButton("Previous");
        JButton nextBtn = new JButton("Next");
        JButton submitBtn = new JButton("Submit Exam");

        prevBtn.setPreferredSize(new Dimension(100, 35));
        nextBtn.setPreferredSize(new Dimension(100, 35));
        submitBtn.setPreferredSize(new Dimension(120, 35));
        prevBtn.setFocusPainted(false);
        nextBtn.setFocusPainted(false);
        submitBtn.setFocusPainted(false);

        navPanel.add(prevBtn);
        navPanel.add(nextBtn);
        navPanel.add(submitBtn);
        examPanel.add(navPanel, BorderLayout.SOUTH);

        resultPage.setLayout(new BorderLayout(15, 15));
        resultPage.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel resultHeader = new JPanel(new GridLayout(2, 1, 5, 5));
        resultScoreLbl.setFont(new Font("SansSerif", Font.BOLD, 20));
        resultTimeLbl.setFont(new Font("SansSerif", Font.PLAIN, 14));
        resultHeader.add(resultScoreLbl);
        resultHeader.add(resultTimeLbl);
        resultPage.add(resultHeader, BorderLayout.NORTH);

        breakdownArea.setEditable(false);
        breakdownArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(breakdownArea);
        resultPage.add(scrollPane, BorderLayout.CENTER);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        logoutBtn.setPreferredSize(new Dimension(120, 35));
        logoutBtn.setFocusPainted(false);
        JPanel resultFooter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultFooter.add(logoutBtn);
        resultPage.add(resultFooter, BorderLayout.SOUTH);

        loginBtn.addActionListener(e -> {
            String user = name.getText();
            String pass = new String(password.getPassword());

            if (user.equals(currentUsername) && pass.equals(currentPassword)) {
                welcomeLbl.setText("Welcome, " + currentUsername + "!");
                newNameTxt.setText(currentUsername);
                newPassTxt.setText(currentPassword);
                cl.show(mainPanel, "Home");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        updateBtn.addActionListener(e -> {
            String updatedName = newNameTxt.getText().trim();
            String updatedPass = new String(newPassTxt.getPassword()).trim();

            if (updatedName.isEmpty() || updatedPass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty!", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                currentUsername = updatedName;
                currentPassword = updatedPass;
                welcomeLbl.setText("Welcome, " + currentUsername + "!");
                nameAndPassword.setText("User Name: " + currentUsername + ", Password: " + currentPassword);
                JOptionPane.showMessageDialog(this, "Profile Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        examTimer = new Timer(1000, e -> {
            timeRemaining--;
            int mins = timeRemaining / 60;
            int secs = timeRemaining % 60;
            timerLbl.setText(String.format("Time: %02d:%02d", mins, secs));

            if (timeRemaining <= 0) {
                examTimer.stop();
                JOptionPane.showMessageDialog(this, "Time is up! Submitting exam automatically.", "Timeout", JOptionPane.WARNING_MESSAGE);
                finishExam(cl, mainPanel);
            }
        });

        startBtn.addActionListener(e -> {
            currentQuestionIndex = 0;
            timeRemaining = 300; 
            timerLbl.setText("Time: 05:00");
            for (Question q : questionList) {
                q.selectedAnswer = -1;
            }
            loadQuestion(currentQuestionIndex);
            cl.show(mainPanel, "Exam");
            examTimer.start();
        });

        nextBtn.addActionListener(e -> {
            saveAnswer(currentQuestionIndex);
            if (currentQuestionIndex < questionList.size() - 1) {
                currentQuestionIndex++;
                loadQuestion(currentQuestionIndex);
            }
        });

        prevBtn.addActionListener(e -> {
            saveAnswer(currentQuestionIndex);
            if (currentQuestionIndex > 0) {
                currentQuestionIndex--;
                loadQuestion(currentQuestionIndex);
            }
        });

        submitBtn.addActionListener(e -> {
            saveAnswer(currentQuestionIndex);
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit the exam?", "Submit Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                examTimer.stop();
                finishExam(cl, mainPanel);
            }
        });

        logoutBtn.addActionListener(e -> {
            name.setText("");
            password.setText("");
            cl.show(mainPanel, "Login");
        });

        mainPanel.add(loginPage, "Login");
        mainPanel.add(homePage, "Home");
        mainPanel.add(examPanel, "Exam");
        mainPanel.add(resultPage, "Result");

        this.add(mainPanel);
        cl.show(mainPanel, "Login");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    OnlineExaminationSystem.this,
                    "Are you sure you want to quit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        this.setResizable(false);
        this.setVisible(true);
    }

    void loadQuestion(int index) {
        Question q = questionList.get(index);
        qNumLbl.setText("Question " + (index + 1) + " of " + questionList.size());
        qTextLbl.setText(q.questionText);

        bg.clearSelection();
        for (int i = 0; i < 4; i++) {
            optionBtns[i].setText(q.options[i]);
            if (q.selectedAnswer == i) {
                optionBtns[i].setSelected(true);
            }
        }
    }

    void saveAnswer(int index) {
        for (int i = 0; i < 4; i++) {
            if (optionBtns[i].isSelected()) {
                questionList.get(index).selectedAnswer = i;
                break;
            }
        }
    }

    void finishExam(CardLayout cl, JPanel mainPanel) {
        int score = 0;
        StringBuilder breakdown = new StringBuilder();
        breakdown.append("Detailed Answer Breakdown:\n");
        breakdown.append("--------------------------------------------------\n");

        for (int i = 0; i < questionList.size(); i++) {
            Question q = questionList.get(i);
            boolean isCorrect = (q.selectedAnswer == q.correctAnswer);
            if (isCorrect) score++;

            breakdown.append("Q").append(i + 1).append(": ").append(q.questionText).append("\n");
            breakdown.append("   Your Answer   : ").append(q.selectedAnswer != -1 ? q.options[q.selectedAnswer] : "Not Answered").append("\n");
            breakdown.append("   Correct Answer: ").append(q.options[q.correctAnswer]).append("\n");
            breakdown.append("   Status        : ").append(isCorrect ? "CORRECT" : "INCORRECT").append("\n\n");
        }

        int secondsTaken = 300 - timeRemaining; 
        int minsTaken = secondsTaken / 60;
        int secsTaken = secondsTaken % 60;

        resultScoreLbl.setText("Exam Results for " + currentUsername + ": " + score + " / " + questionList.size());
        resultTimeLbl.setText(String.format("Time Taken: %02d mins %02d secs", minsTaken, secsTaken));
        breakdownArea.setText(breakdown.toString());
        breakdownArea.setCaretPosition(0);

        cl.show(mainPanel, "Result");
    }
}

class Question {
    String questionText;
    String[] options;
    int correctAnswer;
    int selectedAnswer = -1;

    Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}