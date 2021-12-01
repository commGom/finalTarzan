package ksa.tarzan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ksa.tarzan.dao.MemberDao;
import ksa.tarzan.dao.QuizDao;

public class RankPage extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTable rankTable;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RankPage frame = new RankPage();
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
    // 5. 랭크확인페이지
    public RankPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rank버튼 : RoundedButton_1클래스
        RoundedButton_1 quizStartBtn = new RoundedButton_1("Restart!");
        quizStartBtn.setFont(new Font("굴림", Font.BOLD, 25));
        quizStartBtn.setBounds(76, 31, 235, 64);
        contentPane.add(quizStartBtn);

        // 회원정보수정버튼
        RoundedButton_1 modifyBtn = new RoundedButton_1("회원정보수정");
        modifyBtn.setFont(new Font("굴림", Font.BOLD, 15));
        modifyBtn.setBounds(12, 526, 123, 27);
        contentPane.add(modifyBtn);

        // 로그아웃버튼
        RoundedButton_1 logoutBtn = new RoundedButton_1("로그아웃");
        logoutBtn.setFont(new Font("굴림", Font.BOLD, 15));
        logoutBtn.setBounds(251, 526, 123, 27);
        contentPane.add(logoutBtn);

        JLabel lblNewLabel = new JLabel("Rank");
        lblNewLabel.setForeground(new Color(153, 51, 255));
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
        lblNewLabel.setBounds(28, 120, 56, 37);
        contentPane.add(lblNewLabel);

        JLabel lblNickname = new JLabel("NickName");
        lblNickname.setForeground(new Color(153, 51, 255));
        lblNickname.setFont(new Font("굴림", Font.BOLD, 18));
        lblNickname.setBounds(113, 120, 99, 37);
        contentPane.add(lblNickname);

        JLabel lblTotalScore = new JLabel("Total Score");
        lblTotalScore.setForeground(new Color(153, 51, 255));
        lblTotalScore.setFont(new Font("굴림", Font.BOLD, 18));
        lblTotalScore.setBounds(234, 120, 109, 37);
        contentPane.add(lblTotalScore);

        MemberDao mDao = new MemberDao();
        String[][] data = mDao.sortedMemberListByScore();
        rankTable = new JTable();
        rankTable.setShowVerticalLines(false);
        rankTable.setRowSelectionAllowed(false);
        rankTable.setColumnSelectionAllowed(true);
        rankTable.setToolTipText("");
        rankTable.setFont(new Font("굴림", Font.BOLD, 18));
        rankTable.setModel(new DefaultTableModel(data,new String[] {
                "Rank", "Nick Name", "Total Score"
        }
        ));
        rankTable.setRowHeight(40);
        rankTable.getColumnModel().getColumn(0).setPreferredWidth(45);
        rankTable.getColumnModel().getColumn(2).setMinWidth(33);
        rankTable.setBounds(28, 167, 323, 278);
        contentPane.add(rankTable);

        // Quiz Start 버튼 이벤트 -> QuizPage띄우기
        quizStartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                QuizDao qDao=new QuizDao();
                qDao.serveRandomQuiz();
                QuizDao.setInstance(qDao);
                setVisible(false);
                new QuizPage();
            }
        });

        // 로그아웃 버튼 이벤트 -> LogInPage
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mDao.logout();
                new LogInPage();
            }
        });

        // 회원정보수정 버튼 이벤트
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
