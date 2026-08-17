
import java.awt.*;
import javax.swing.*;

public class Aakash_4{
    public static void main(String[] args){
        new OnlineExaminationSystem();
    }
}

class OnlineExaminationSystem extends JFrame{
    CardLayout cl = new CardLayout();
    JPanel mainPanel;
    JPanel homePage;
    JLabel welcomeMsg;
    JButton loginBtn;
    JButton regiBtn;
    
    OnlineExaminationSystem(){
        mainPanel = new JPanel(cl);
        welcomeMsg = new JLabel("Welcome to Examination Software");
        homePage = new JPanel();
        loginBtn = new JButton("Login");
        regiBtn = new JButton("Register");
        mainPanel.add(homePage);
        cl.show(mainPanel, "homePage");
        welcomeMsg.setBounds(0, 0, 300, 100);
        homePage.add(welcomeMsg);

        this.add(mainPanel);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}