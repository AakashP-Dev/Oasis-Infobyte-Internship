
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

        loginPage.setLayout(new GridLayout(3, 2));
        JLabel enterName = new JLabel("Enter User Name:");
        JLabel enterPassword = new JLabel("Enter Password:");
        JTextField name = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JLabel nameAndPassword = new JLabel("User Name: Aakash, Password: Aakash123");
        JButton loginBtn = new JButton("Login");
        JButton clearBtn = new JButton("Clear");
        loginPage.add(enterName);
        loginPage.add(name);
        loginPage.add(enterPassword);
        loginPage.add(password);
        loginPage.add(nameAndPassword);
        loginPage.add(new JLabel(""));
        loginPage.add(loginBtn);
        loginPage.add(clearBtn);


        homePage.setLayout(null);
        JButton startBtn = new JButton("Start Exam");
        JLabel title = new JLabel("Online Examination");
        title.setBounds(245, 20, 300, 30);
        startBtn.setBounds(250, 280, 100, 40);
        startBtn.setFocusPainted(false);
        startBtn.addActionListener((e) -> {
            cl.show(question1, "Q1");
        });
        homePage.add(title);
        homePage.add(startBtn);
        
        mainPanel.add(loginPage);
        mainPanel.add(homePage);
        mainPanel.add(question1);
        mainPanel.add(question2);
        mainPanel.add(question3);
        mainPanel.add(question4);
        mainPanel.add(question5);
        mainPanel.add(resultPage);

        this.add(mainPanel);
        cl.show(mainPanel, "loginPage");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}