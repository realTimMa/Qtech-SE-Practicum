package cn.qdlgdx.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import cn.qdlgdx.dao.AdminDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 * 
 * @author Tim Ma
 *
 */
public class AddUserFrame extends JInternalFrame {
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
					AddUserFrame frame = new AddUserFrame();
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
	public AddUserFrame() {
		setTitle("\u6DFB\u52A0\u5458\u5DE5");
		setBounds(100, 100, 687, 438);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(93, 66, 58, 15);
		getContentPane().add(lblNewLabel);

		txtId = new JTextField();
		txtId.setBounds(188, 63, 104, 21);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(93, 111, 58, 15);
		getContentPane().add(lblNewLabel_1);

		txtName = new JTextField();
		txtName.setBounds(188, 108, 104, 21);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(93, 153, 58, 15);
		getContentPane().add(lblNewLabel_2);

		JButton btnSub = new JButton("\u786E\u8BA4");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = Integer.parseInt(txtId.getText().trim());
				String userName = txtName.getText().trim();
				String userPwd = txtPwd.getText().trim();
//				if(userId<999999999&&userId>0&&userName.length()>0&&userName.length()<10&&
//						userPwd.length()>0&&userPwd.length()<10) {
				int flag = AdminDao.insertUsr(userId, userName, userPwd);
				if (flag == 0) {
					JOptionPane.showMessageDialog(null, "添加成功！");
				} else {
					JOptionPane.showMessageDialog(null, "添加失败！");
				}
//				}else {
//					JOptionPane.showMessageDialog(null, "数据不合法！");
//				}
			}
		});
		btnSub.setBounds(88, 189, 97, 23);
		getContentPane().add(btnSub);

		JButton btnExit = new JButton("\u53D6\u6D88");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUserFrame.this.setVisible(false);
			}
		});
		btnExit.setBounds(195, 189, 97, 23);
		getContentPane().add(btnExit);

		txtPwd = new JPasswordField();
		txtPwd.setBounds(188, 150, 104, 21);
		getContentPane().add(txtPwd);

	}
}
