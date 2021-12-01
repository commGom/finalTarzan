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
import javax.swing.Action;
import javax.swing.DropMode;
import javax.swing.Icon;
import javax.swing.SwingConstants;

//1. 맨 첫 화면
public class LogInPage extends JFrame {

    private JPanel contentPane;
    private JTextField ID_textFiled;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogInPage frame = new LogInPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    // 1. 맨 첫 화면 : 로그인
    public LogInPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 51, 255)); //138, 43, 226
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
        lblNewLabel.setBounds(73, 240, 24, 46);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PW");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
        lblNewLabel_1.setBounds(70, 287, 24, 46);
        contentPane.add(lblNewLabel_1);

        //ID입력창
        ID_textFiled = new JTextField();
        ID_textFiled.setColumns(10);
        ID_textFiled.setBounds(103, 240, 194, 46);
        contentPane.add(ID_textFiled);

        //pw입력창
        JPasswordField PW_textFiled = new JPasswordField(10);//pw 암호화되어서 보이는 텍스트필드
        PW_textFiled.setColumns(10);
        PW_textFiled.setBounds(103, 288, 194, 46);

        contentPane.add(PW_textFiled);

        //RoundedButton클래스사용
        //로그인버튼
        RoundedButton LogInBtn = new RoundedButton("로그인");
        LogInBtn.setFont(new Font("굴림", Font.BOLD, 15));
        LogInBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        LogInBtn.setBounds(206, 344, 92, 46);
        contentPane.add(LogInBtn);

        //회원가입버튼
        RoundedButton JoinBtn = new RoundedButton("회원가입");
        JoinBtn.setFont(new Font("굴림", Font.BOLD, 15));
        JoinBtn.setBounds(103, 344, 92, 46);
        contentPane.add(JoinBtn);

        JLabel Title = new JLabel("Quiz");
        Title.setForeground(new Color(255, 255, 255));
        Title.setFont(new Font("굴림", Font.BOLD, 70));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setBounds(118, 134, 162, 96);
        contentPane.add(Title);

        JLabel TitleLabel_TARZAN = new JLabel("TARZAN");
        TitleLabel_TARZAN.setFont(new Font("굴림", Font.BOLD, 20));
        TitleLabel_TARZAN.setBackground(new Color(138, 43, 226));
        TitleLabel_TARZAN.setForeground(new Color(255, 255, 255));
        TitleLabel_TARZAN.setBounds(191, 121, 92, 29);
        contentPane.add(TitleLabel_TARZAN);

        //로그인버튼 이벤트
        LogInBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                MemberDao mDao = new MemberDao();
                String id=ID_textFiled.getText();
                String pw=PW_textFiled.getText();
                System.out.println("main->login 실행");

                //Member객체를 받아서 member를 로그인한 사용자 정보 user에 넣는다.
                Member user=mDao.login(id,pw);
                System.out.println("user=>"+user);
                if (user!=null){
                    //로그인 성공 메시지 보여주기
                    JOptionPane.showMessageDialog(null, String.format("%s 님 반갑습니다!",user.getNickName()));
                    QuizDao qDao=new QuizDao();
                    QuizDao.setInstance(qDao);
                    qDao.serveRandomQuiz();
                    new QuizPage();
                    setVisible(false);
                }else{
                    //로그인 실패 메시지 보여주기
                    JOptionPane.showMessageDialog(null, "로그인 실패 \n 일치하는 정보가 없습니다. ");
                    new LogInPage();
                    setVisible(false);
                }


            }
        });

        //회원가입버튼 이벤트
        JoinBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // 회원가입 버튼 누르면 로그인창은 꺼짐
                new JoinPage();  // 회원가입 창으로 이동
            }
        });
        setVisible(true);
        setBounds(100, 100, 400, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
