
import java.awt.*;
import javax.swing.*;

public class Aakash_4{
    public static void main(String[] args){
        new OnlineExaminationSystem();
    }
}

class OnlineExaminationSystem extends JFrame{
    OnlineExaminationSystem(){
        CardLayout cl = new CardLayout();
        JPanel mainPanel = new JPanel(cl);
        JPanel loginPage = new JPanel();
        JPanel homePage = new JPanel();
        JPanel question1 = new JPanel();
        JPanel question2 = new JPanel();
        JPanel question3 = new JPanel();
        JPanel question4 = new JPanel();
        JPanel question5 = new JPanel();
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
        gbc.gridy=0;
        gbc.gridwidth=1;
        enterName.setFont(labelFont);
        wrapper.add(enterName, gbc);
        
        JTextField name = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy=0;
        gbc.gridwidth=1;
        name.setFont(inputFont);
        name.setPreferredSize(new Dimension(200, 32));
        wrapper.add(name, gbc);
        
        JLabel enterPassword = new JLabel("Enter Password:");
        gbc.gridx = 0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        enterPassword.setFont(labelFont);
        wrapper.add(enterPassword, gbc);
        
        JPasswordField password = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        password.setFont(inputFont);
        password.setPreferredSize(new Dimension(200, 32));
        wrapper.add(password, gbc);
        
        JLabel nameAndPassword = new JLabel("User Name: Aakash, Password: Aakash123");
        gbc.gridx = 0;
        gbc.gridy=2;
        gbc.gridwidth=2;
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

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        wrapper.add(btnPanel, gbc);

        loginPage.add(wrapper, BorderLayout.CENTER);
        
        loginBtn.setFocusPainted(false);
        clearBtn.setFocusPainted(false);

        clearBtn.addActionListener(e -> {
            name.setText("");
            password.setText("");
        });

        loginBtn.addActionListener(e -> {
            String user = name.getText();
            String pass = new String(password.getPassword());

            if (user.equals("Aakash") && pass.equals("Aakash123")) {
                cl.show(mainPanel, "Home");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        homePage.setLayout(null);
        JButton startBtn = new JButton("Start Exam");
        JLabel title = new JLabel("Online Examination");
        title.setBounds(245, 20, 300, 30);
        startBtn.setBounds(250, 280, 100, 40);
        startBtn.setFocusPainted(false);
        startBtn.addActionListener((e) -> {
            cl.show(mainPanel, "Q1");
        });
        homePage.add(title);
        homePage.add(startBtn);
        
        mainPanel.add(loginPage, "Login");
        mainPanel.add(homePage, "Home");
        mainPanel.add(question1, "Q1");
        mainPanel.add(question2, "Q2");
        mainPanel.add(question3, "Q3");
        mainPanel.add(question4, "Q4");
        mainPanel.add(question5, "Q5");
        mainPanel.add(resultPage, "Result");

        this.add(mainPanel);
        cl.show(mainPanel, "Login");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}