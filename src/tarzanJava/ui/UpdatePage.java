package tarzanJava.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePage extends JFrame{
    private JPanel updatePanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton updateButton;
    private JTextField textField2;


    public UpdatePage() {
        this.add(updatePanel);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        pack();
        setVisible(true);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "회원정보 변경 성공!");
                setVisible(false);
                new MainPage();
            }
        });
    }

}
