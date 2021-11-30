package tarzanJava.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RankPage extends JFrame{
    //표 넣어볼 계획
//    private MemberManager memberManager;

    public RankPage() {
//        memberManager= MemberManagerImpl.getInstance();
//        String[] headings=new String[]{"Rank","NickName","Total Score"};
//        String[][] data= Manager.getSortedMemberInfoToArray();
//        JTable rankTable=new JTable(data,headings);
//        JScrollPane scrollPane=new JScrollPane(rankTable);

        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.setBounds(20,30,560,340);

        JButton quizButton=new JButton("퀴즈 풀기");
        quizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                QuizManagerImpl.getInstance().serveRandomQuiz();
                setVisible(false);
                new QuizPage();
            }
        });
        JButton logoutButton=new JButton("로그아웃");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                memberManager.logout();
                setVisible(false);
                new MainPage();
            }
        });
//        add(scrollPane,BorderLayout.CENTER);
        add(quizButton,BorderLayout.PAGE_START);

        add(logoutButton,BorderLayout.PAGE_END);
        setBackground(new Color(125,22,242));
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        pack();
        setVisible(true);


    }


}
