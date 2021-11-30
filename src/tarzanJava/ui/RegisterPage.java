package tarzanJava.ui;

import tarzanJava.domain.Member;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends JFrame{
    private JPanel registerPanel;
    private JButton registerButton;
    private JTextField memId;
    private JTextField nickName;
    private JTextField memPw;


    public RegisterPage() {
        add(registerPanel);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        pack();
        setVisible(true);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Member memberInfo=new Member(memId.getText(),memPw.getText(),nickName.getText());
//                boolean registerYN=memberManager.registerMember(memberInfo);
                boolean registerYN=true;
                String registerMessage="회원가입 실패";
                if (registerYN){
                    registerMessage=nickName.getText()+"님 회원가입 성공!";
                    JOptionPane.showMessageDialog(null, registerMessage);
                }

                JOptionPane.showMessageDialog(null, registerMessage);

                setVisible(false);
                new MainPage();
            }
        });
    }
}
