package tarzanJava.ui;


import tarzanJava.domain.Member;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPage extends JFrame{
    private JPanel outerResultPage;
    private JButton updateButton;
    private JButton logoutButton;
    private JPanel innerResultPage;
    private JLabel correctAnswers;
    private JLabel wrongAnswers;
    private JLabel totalScore;
    private JButton rankButton;

    public ResultPage() {
        setContentPane(outerResultPage);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        pack();
        setVisible(true);
//        quizManager= QuizManagerImpl.getInstance();
//        memberManager= MemberManagerImpl.getInstance();
//        int correctCount=quizManager.markQuiz();
        Member user=Session.getUser();
//        user.setScore(user.getScore()+correctCount);
//        correctAnswers.setText(""+correctCount);
//        wrongAnswers.setText(""+(10-correctCount));
        totalScore.setText(""+user.getScore());

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Member user= Session.getUser();
                if(user!=null){
                    System.out.println("user가 null이 아님");
                    new UpdatePage();
                }
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                memberManager.logout();
                setVisible(false);
                new MainPage();
            }
        });
        rankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RankPage();
            }
        });
    }
}
