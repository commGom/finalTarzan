package tarzanJava.ui;



import tarzanJava.domain.Member;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame{
    private JLabel titleLable;
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton registerButton;
    private JTextField memId;
    private JTextField memPw;
    private JButton memberssButton;
    //로그인한 사용자 정보 (로그인 안하면 null)

    public MainPage() {
        System.out.println("메인 페이지 호출");
//        ArrayList<Member> memberDB=MemberDB.getMemberDB();
//        QuizManager quizManager=new QuizManagerImpl();
//        System.out.println(memberDB);

        setTitle("Tarzan Java");
        setContentPane(mainPanel);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        pack();
        setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("main->registerPage 호출");
                new RegisterPage();
                setVisible(false);

            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=memId.getText();
                String pw=memPw.getText();
                System.out.println("main->login 실행");

                //Member객체를 받아서 member를 로그인한 사용자 정보 user에 넣는다.
//                Member user=MemberManagerImpl.getInstance().login(id,pw);
                Member user=null;
                System.out.println("user=>"+user);
                if (user!=null){
                    //Session에 user정보 설정
                    Session.setUser(user);
                    //로그인 성공 메시지 보여주기
                    JOptionPane.showMessageDialog(null, String.format("%s 님 반갑습니다!",user.getNickName()));
//                    QuizManagerImpl.getInstance().serveRandomQuiz();
                    new QuizPage();
                    setVisible(false);
                }else{
                    //로그인 실패 메시지 보여주기
                    JOptionPane.showMessageDialog(null, "로그인 실패 \n 일치하는 정보가 없습니다. ");
                    new MainPage();
                    setVisible(false);
                }

            }
        });
        memberssButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MembersPage();
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new MainPage();

    }
}
