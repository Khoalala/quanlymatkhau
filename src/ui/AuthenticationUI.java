/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import bean.UserBean;
import dao.UserDaoImpl;
import utils.Constants;
import utils.Utils;

import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Cursor;

public class AuthenticationUI extends JFrame implements ActionListener{

	public JFrame frame;
	private JTextField emailTxtfield;
	private JPasswordField passwordTxtfield;
	private JButton connexionBtn;
	private JButton goToInscription;
	JLabel iconViewOrHidePasswordEditLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthenticationUI window = new AuthenticationUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AuthenticationUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(394, 0, 406, 478);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSoumgraphic = new JLabel("<html>\nQuản Lý Mật Khẩu\n</html>");
		lblSoumgraphic.setForeground(new Color(200, 170, 200));//112,128,144
		lblSoumgraphic.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSoumgraphic.setBounds(127, 282, 272, 27);//80,
		panel.add(lblSoumgraphic);
		
		JLabel label = new JLabel("");
		label.setAlignmentX(0.5f);
		label.setBorder(null);
		//./assets/img/pm_logo.png
		label.setIcon(new ImageIcon(AuthenticationUI.class.getResource("/ui/images/pm_logo.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(141, 125, 133, 145);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 179, 113));
		panel_1.setBounds(0, 0, 395, 478);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chào mừng quay trở lại!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(51, 75, 320, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblEnterYourDetails = new JLabel("Đăng nhập vào tài khoản:");
		lblEnterYourDetails.setForeground(Color.WHITE);
		lblEnterYourDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterYourDetails.setBounds(51, 103, 282, 31);
		panel_1.add(lblEnterYourDetails);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(51, 210, 320, 12);
		panel_1.add(separator_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(51, 165, 282, 16);
		panel_1.add(lblEmail);
		
		emailTxtfield = new JTextField();
		emailTxtfield.setCaretColor(new Color(255, 255, 255));
		emailTxtfield.setForeground(Color.WHITE);
		emailTxtfield.setFont(new Font("Tahoma", Font.BOLD, 12));
		emailTxtfield.setColumns(10);
		emailTxtfield.setBorder(null);
		emailTxtfield.setBackground(new Color(60, 179, 113));
		emailTxtfield.setBounds(51, 193, 320, 16);
		panel_1.add(emailTxtfield);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(51, 234, 282, 16);
		panel_1.add(lblPassword);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(51, 279, 320, 12);
		panel_1.add(separator_2);
		
		passwordTxtfield = new JPasswordField();
		passwordTxtfield.setBorder(null);
		passwordTxtfield.setCaretColor(new Color(255, 255, 255));
		passwordTxtfield.setBackground(new Color(60, 179, 113));
		passwordTxtfield.setForeground(new Color(255, 255, 255));
		passwordTxtfield.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordTxtfield.setBounds(51, 262, 282, 16);
		passwordTxtfield.setEchoChar('*');
		panel_1.add(passwordTxtfield);
		
		connexionBtn = new JButton("Đăng Nhập");
		connexionBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		connexionBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		connexionBtn.setForeground(new Color(255, 255, 255));
		connexionBtn.setContentAreaFilled(false);
		connexionBtn.setFocusPainted(false);
		connexionBtn.setBorder(new LineBorder(new Color(255, 255, 255)));
		connexionBtn.setBounds(51, 320, 320, 40);
		connexionBtn.setActionCommand("connexionBtn");
		connexionBtn.addActionListener(this);
		panel_1.add(connexionBtn);
		
		goToInscription = new JButton("<html>\nBạn chưa có tài khoản ? <u>Đăng ký</u>\n</html>");
		goToInscription.setBorderPainted(false);
		goToInscription.setContentAreaFilled(false);
		goToInscription.setOpaque(false);
		goToInscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goToInscription.setFont(new Font("Tahoma", Font.BOLD, 12));
		goToInscription.setBorder(null);
		goToInscription.setForeground(new Color(255, 255, 255));
		goToInscription.setBounds(51, 381, 320, 21);
		goToInscription.setActionCommand("goToInscription");
		goToInscription.addActionListener(this);
		panel_1.add(goToInscription);
		
		iconViewOrHidePasswordEditLbl = new JLabel("");
		iconViewOrHidePasswordEditLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconViewOrHidePasswordEditLbl.setIcon(new ImageIcon(AuthenticationUI.class.getResource("/ui/images/eye_white.png")));
		iconViewOrHidePasswordEditLbl.setForeground(new Color(112, 128, 144));
		iconViewOrHidePasswordEditLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		iconViewOrHidePasswordEditLbl.setBounds(345, 259, 23, 23);
		panel_1.add(iconViewOrHidePasswordEditLbl);
		
		iconViewOrHidePasswordEditLbl.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Utils.showOrHidePasswordTxtFields(passwordTxtfield, iconViewOrHidePasswordEditLbl, '*');
			}
		});
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("connexionBtn".equals(e.getActionCommand())) {
			connexion();
		}else if("goToInscription".equals(e.getActionCommand())) {
			backToInscriptionWdw();
		}
	}
	
	private void connexion() {
		String emailUser = emailTxtfield.getText().toString();
		String passwordUser = passwordTxtfield.getText().toString();
		if ((!Utils.isNullOrEmpty(emailUser)) && (!Utils.isNullOrEmpty(passwordUser))) {
			try {
				
				UserDaoImpl daoImpl = new UserDaoImpl();
				UserBean userBean = new UserBean();
				userBean = daoImpl.authenticationUser(emailUser.toLowerCase(), passwordUser);
				if ((userBean.getCallDbFunctionBean().getCodeRetour() == Constants.COMPLETED_SUCCESSFULLY) && (userBean.getCallDbFunctionBean().isErrorRetour() == false)) {
					AdminUI adminUI = new AdminUI(userBean);
					frame.dispose();
					adminUI.frame.setVisible(true);
				}else if((userBean.getCallDbFunctionBean().getCodeRetour() == Constants.NOT_FOUND) && (userBean.getCallDbFunctionBean().isErrorRetour() == true)){
					Utils.showErrorMessage(frame, userBean.getCallDbFunctionBean().getMessageRetour());
				}else if((userBean.getCallDbFunctionBean().getCodeRetour() == Constants.PASSWORD_ERROR) && (userBean.getCallDbFunctionBean().isErrorRetour() == true)) {
					Utils.showErrorMessage(frame, userBean.getCallDbFunctionBean().getMessageRetour());
				}else {
					Utils.showErrorMessage(frame, "Đã xảy ra lỗi trong quá trình xác thực, vui lòng thử lại sau!");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Utils.showErrorMessage(frame, "Vui lòng nhập email và mật khẩu!");
		}
	}
	
	private void backToInscriptionWdw() {
		InscriptionUI windowInscUI = new InscriptionUI();
		frame.dispose();
		windowInscUI.frame.setVisible(true);
	}
}
