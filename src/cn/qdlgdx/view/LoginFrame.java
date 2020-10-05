package cn.qdlgdx.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.qdlgdx.dao.LoginDao;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 * 
 * @author Tim Ma
 *
 */
public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JPasswordField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("\u767B\u5F55\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "\u5458\u5DE5", "\u79D8\u4E66", "\u7BA1\u7406\u5458" }));
		comboBox.setBounds(135, 50, 97, 23);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("\u6743\u9650\uFF1A");
		lblNewLabel.setBounds(57, 52, 70, 19);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setBounds(57, 101, 58, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_2.setBounds(57, 126, 58, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setBounds(57, 151, 58, 15);
		contentPane.add(lblNewLabel_3);

		txtId = new JTextField();
		txtId.setBounds(135, 98, 97, 21);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(135, 123, 97, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JButton btnSub = new JButton("\u786E\u8BA4");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = txtId.getText().trim();
				String userName = txtName.getText().trim();
				String userPwd = txtPwd.getText().trim();
				String userLvl = comboBox.getSelectedItem().toString().trim();
				int flag = LoginDao.loginCheck(userId, userName, userPwd, userLvl);
				if (flag == 1) {
					if (userLvl.equals("管理员")) {
						new AdminFrame(userName, userPwd).setVisible(true);
						LoginFrame.this.setVisible(false);
					} else if (userLvl.equals("秘书")) {
						new SecretaryFrame(userName, userPwd).setVisible(true);
						LoginFrame.this.setVisible(false);
					} else if (userLvl.equals("员工")) {
						new UserFrame(userId, userName, userPwd,userLvl).setVisible(true);
						LoginFrame.this.setVisible(false);
					}
				} else if (flag == 0) {
					JOptionPane.showMessageDialog(null, "用户名或密码错误！");
				} else if (flag == -1) {
					JOptionPane.showMessageDialog(null, "系统错误！");
				}
			}
		});
		btnSub.setBounds(54, 182, 97, 23);
		contentPane.add(btnSub);

		JButton btnExit = new JButton("\u53D6\u6D88");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(193, 182, 97, 23);
		contentPane.add(btnExit);

		txtPwd = new JPasswordField();
		txtPwd.setBounds(135, 148, 97, 21);
		contentPane.add(txtPwd);
	}
}
