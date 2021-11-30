package tarzanJava.ui;


import tarzanJava.domain.Quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizPage extends JFrame{
    private JPanel outerQuizPage;
    private JLabel questionNumber;
    private JTextPane question;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JPanel innerQuizPage;
    private JLabel one;
    private JLabel two;
    private JLabel three;
    private JLabel four;
    private Quiz currentQuiz;
    private char answerYN;
    private String alertMessage;
    //정답을 누를 때 마다 퀴즈문제와 입력한 정답을 저장하고, 다음 문제를 보여주도록 구현
    public QuizPage() {
        setContentPane(outerQuizPage);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        pack();
        setVisible(true);
//        quizManager=QuizManagerImpl.getInstance();
//        currentQuiz=quizManager.serveEachQuiz();
//        System.out.println(currentQuiz);
        if(currentQuiz!=null){
            questionNumber.setText("Question. "+currentQuiz.getQuizNo());
            question.setText(currentQuiz.getQuestion());
            one.setText(currentQuiz.getEx01());
            two.setText(currentQuiz.getEx02());
            three.setText(currentQuiz.getEx03());
            four.setText(currentQuiz.getEx04());
        }else{
            //다음 페이지로 넘김.
            setVisible(false);
            new ResultPage();
        }

        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                answerYN=quizManager.solveQuiz(1,currentQuiz);
                answerYN='N';
                if (answerYN=='Y'){
                    alertMessage="정답 여부\n : Yes \n ";
                }else{
                    alertMessage="No";
                }
                JOptionPane.showMessageDialog(null, alertMessage);
                setVisible(false);
                new QuizPage();
            }
        });
        twoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                answerYN=quizManager.solveQuiz(1,currentQuiz);
                answerYN='N';
                if (answerYN=='Y'){
                    alertMessage="정답 여부\n : Yes \n ";
                }else{
                    alertMessage="No";
                }
                JOptionPane.showMessageDialog(null, alertMessage);
                setVisible(false);
                new QuizPage();
            }
        });
        threeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                answerYN=quizManager.solveQuiz(1,currentQuiz);
                answerYN='N';
                if (answerYN=='Y'){
                    alertMessage="정답 여부\n : Yes \n ";
                }else{
                    alertMessage="No";
                }
                JOptionPane.showMessageDialog(null, alertMessage);
                setVisible(false);
                new QuizPage();
            }
        });
        fourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                answerYN=quizManager.solveQuiz(1,currentQuiz);
                answerYN='N';
                if (answerYN=='Y'){
                    alertMessage="정답 여부\n : Yes \n ";
                }else{
                    alertMessage="No";
                }
                JOptionPane.showMessageDialog(null, alertMessage);
                setVisible(false);
                new QuizPage();
            }
        });
    }

}
