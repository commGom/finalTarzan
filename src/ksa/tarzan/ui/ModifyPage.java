package ksa.tarzan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import ksa.tarzan.dao.MemberDao;
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

public class ModifyPage extends JFrame {

    private JPanel contentPane;
    private JTextField NickName_textField;
    private JTextField PW_textField;
    private JTextField ID_textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ModifyPage frame = new ModifyPage();
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
    // 6. 회원정보수정
    public ModifyPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 51, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
        lblNewLabel.setBounds(74, 185, 24, 46);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1_1 = new JLabel("닉네임");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(47, 243, 57, 46);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1 = new JLabel("PW");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
        lblNewLabel_1.setBounds(66, 299, 24, 46);
        contentPane.add(lblNewLabel_1);

        // ID입력창
        ID_textField = new JTextField();
        ID_textField.setText(Session.getUser().getMemId());
        ID_textField.setEditable(false);
        ID_textField.setBounds(99, 183, 194, 51);
        contentPane.add(ID_textField);
        ID_textField.setColumns(10);

        // 닉네임입력창
        NickName_textField = new JTextField();
        NickName_textField.setColumns(10);
        NickName_textField.setBounds(99, 244, 194, 46);
        contentPane.add(NickName_textField);

        // pw입력창
        JPasswordField PW_textField = new JPasswordField(10);// pw 암호화되어서 보이는 텍스트필드
        PW_textField.setColumns(10);
        PW_textField.setBounds(99, 300, 194, 46);
        contentPane.add(PW_textField);

        // RoundedButton클래스사용
        // 회원정보수정버튼
        RoundedButton btnNewButton_1 = new RoundedButton("회원정보수정");
        btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 15));
        btnNewButton_1.setBounds(99, 375, 194, 46);
        contentPane.add(btnNewButton_1);

        // 회원정보수정 버튼이벤트
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(ID_textField.getText() + "," + PW_textField.getText() + "," + NickName_textField.getText());
                MemberDao mDao = new MemberDao();
                Member memberInfo = new Member(ID_textField.getText(), PW_textField.getText(),NickName_textField.getText());
                System.out.println(memberInfo);
                boolean registerYN = mDao.modify(memberInfo);
                String registerMessage = "";
                if (registerYN) {
                    registerMessage = NickName_textField.getText() + "님 회원정보 변경 완료!";
                }
                JOptionPane.showMessageDialog(null, registerMessage);
                setVisible(false);
                new LogInPage();
            }
        });

        setVisible(true);
        setBounds(100, 100, 400, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
