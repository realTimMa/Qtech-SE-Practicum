package cn.qdlgdx.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.qdlgdx.dao.AdminDao;
import cn.qdlgdx.dao.UserDao;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Tim Ma
 *
 */
public class EditUserPwd extends JInternalFrame {
	private JTextField txtId;
	private JPasswordField txtPwd;
	private JPasswordField txtPwdConfirm;
	private String usrId;
	private String usrName;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditUserPwd frame = new EditUserPwd();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EditUserPwd(String usrId, String usrName) {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		this.usrId = usrId;
		this.usrName = usrName;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(51, 45, 58, 15);
		getContentPane().add(lblNewLabel);

		txtId = new JTextField();
		txtId.setBounds(119, 42, 96, 21);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		txtId.setText(this.usrId);
		txtId.setEditable(false);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(51, 88, 58, 15);
		getContentPane().add(lblNewLabel_1);

		JTextField txtName = new JTextField();
		txtName.setBounds(119, 85, 96, 21);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setText(this.usrName);
		txtName.setEditable(false);

		JLabel lblNewLabel_2 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(51, 132, 58, 15);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setBounds(51, 171, 69, 15);
		getContentPane().add(lblNewLabel_3);

		txtPwd = new JPasswordField();
		txtPwd.setBounds(119, 129, 96, 21);
		getContentPane().add(txtPwd);

		txtPwdConfirm = new JPasswordField();
		txtPwdConfirm.setBounds(119, 168, 96, 21);
		getContentPane().add(txtPwdConfirm);

		JButton btnSub = new JButton("\u786E\u8BA4");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = txtId.getText().trim();
				String userPwd = txtPwd.getText().trim();
				String userPwdConfirm = txtPwdConfirm.getText().trim();
//				if(userPwd.length()<10&&userPwd.length()>0) {
				if (userPwd.equals(userPwdConfirm)) {
					UserDao UserDao = new UserDao();
					int flag = UserDao.updateUsrPwd(userId, userPwd);
					if (flag == 0) {
						JOptionPane.showMessageDialog(null, "修改成功！");
					} else {
						JOptionPane.showMessageDialog(null, "修改失败！");
					}
				} else {
					JOptionPane.showMessageDialog(null, "两次输入密码不一致！");
				}
//				}else {
//					JOptionPane.showMessageDialog(null, "数据不合法！");
//				}
			}
		});
		btnSub.setBounds(23, 218, 97, 23);
		getContentPane().add(btnSub);

		JButton btnExit = new JButton("\u53D6\u6D88");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditUserPwd.this.setVisible(false);
			}
		});
		btnExit.setBounds(156, 218, 97, 23);
		getContentPane().add(btnExit);

	}
}
