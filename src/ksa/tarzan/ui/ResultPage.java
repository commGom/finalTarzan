package ksa.tarzan.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import ksa.tarzan.dao.MemberDao;
import ksa.tarzan.dao.QuizDao;
import ksa.tarzan.dto.Member;
import ksa.tarzan.util.Session;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ResultPage extends JFrame {

    private JPanel contentPane;
    private JTextField textField;


    /**
     * Create the frame.
     */
    // 4. 채점 페이지
    public ResultPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 51, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("맞힌 문제 수 :");
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(46, 184, 134, 57);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("틀린 문제 수 :");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_2.setBounds(46, 251, 134, 57);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("총 보유 점수 :");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_3.setBounds(46, 318, 134, 57);
        contentPane.add(lblNewLabel_3);

        JLabel CorrectAns_Label = new JLabel("6");
        CorrectAns_Label.setHorizontalAlignment(SwingConstants.RIGHT);
        CorrectAns_Label.setFont(new Font("굴림", Font.BOLD, 20));
        CorrectAns_Label.setBounds(205, 184, 73, 57);
        contentPane.add(CorrectAns_Label);

        JLabel WrongAns_Label = new JLabel("4");
        WrongAns_Label.setHorizontalAlignment(SwingConstants.RIGHT);
        WrongAns_Label.setFont(new Font("굴림", Font.BOLD, 20));
        WrongAns_Label.setBounds(205, 251, 73, 57);
        contentPane.add(WrongAns_Label);

        JLabel TotalScore_Label = new JLabel("15");
        TotalScore_Label.setHorizontalAlignment(SwingConstants.RIGHT);
        TotalScore_Label.setFont(new Font("굴림", Font.BOLD, 20));
        TotalScore_Label.setBounds(205, 318, 73, 57);
        contentPane.add(TotalScore_Label);

        //Rank버튼 : RoundedButton_1클래스
        RoundedButton_1 rankBtn = new RoundedButton_1("RANK");
        rankBtn.setFont(new Font("굴림", Font.BOLD, 20));
        rankBtn.setBounds(76, 402, 229, 57);
        contentPane.add(rankBtn);

        //회원정보수정버튼
        RoundedButton_1 modifyBtn = new RoundedButton_1("회원정보수정");
        modifyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        modifyBtn.setFont(new Font("굴림", Font.BOLD, 15));
        modifyBtn.setBounds(22, 501, 123, 37);
        contentPane.add(modifyBtn);

        //로그아웃버튼
        RoundedButton_1 logoutBtn = new RoundedButton_1("로그아웃");
        logoutBtn.setFont(new Font("굴림", Font.BOLD, 15));
        logoutBtn.setBounds(270, 501, 93, 37);
        contentPane.add(logoutBtn);

        JLabel Title = new JLabel("Result");
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("굴림", Font.BOLD, 35));
        Title.setBounds(133, 90, 106, 41);
        contentPane.add(Title);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(22, 59, 341, 432);
        contentPane.add(panel_1);


        QuizDao qDao=QuizDao.getInstance();
        MemberDao mDao=new MemberDao();
        int correctCount=qDao.markQuiz();
        Member user=Session.getUser();
        int score=user.getScore()+correctCount;
        user.setScore(score);
        mDao.updateScore(user);
        CorrectAns_Label.setText(""+correctCount);
        WrongAns_Label.setText(""+(10-correctCount));
        TotalScore_Label.setText(""+user.getScore());


        //Rank 버튼 이벤트 -> RankPage 창 띄우기
        rankBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RankPage();
            }
        });

        //로그아웃 버튼 이벤트 -> LogInPage
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mDao.logout();
                setVisible(false);
                new LogInPage();
            }
        });

        //회원정보수정 이벤트 -> ModifyPage
        modifyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ModifyPage();
            }
        });

        setVisible(true);
        setBounds(100, 100, 400, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
