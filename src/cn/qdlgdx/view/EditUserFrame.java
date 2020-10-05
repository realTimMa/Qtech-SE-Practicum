package cn.qdlgdx.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class EditUserFrame extends JInternalFrame {

	private JTextField txtSearch;
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
					EditUserFrame frame = new EditUserFrame();
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
	public EditUserFrame() {
		setTitle("\u7F16\u8F91\u7528\u6237");
		setBounds(100, 100, 497, 368);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(57, 41, 58, 15);
		getContentPane().add(lblNewLabel);

		txtSearch = new JTextField();
		txtSearch.setBounds(136, 38, 122, 21);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("\u67E5\u8BE2");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtSearch.getText().trim();
				String[] usr = null;
				usr = AdminDao.selectUsr(id);
				txtId.setText(usr[0]);
				txtName.setText(usr[1]);
				txtPwd.setText(usr[2]);
			}
		});
		btnSearch.setBounds(307, 37, 97, 23);
		getContentPane().add(btnSearch);

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setBounds(57, 104, 58, 15);
		getContentPane().add(lblNewLabel_1);

		txtId = new JTextField();
		txtId.setText("");
		txtId.setBounds(136, 101, 122, 21);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_2.setBounds(57, 149, 58, 15);
		getContentPane().add(lblNewLabel_2);

		txtName = new JTextField();
		txtName.setBounds(136, 146, 122, 21);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setBounds(57, 195, 58, 15);
		getContentPane().add(lblNewLabel_3);

		JButton btnSub = new JButton("\u786E\u8BA4");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int userId = Integer.parseInt(txtId.getText().trim());
				String userName = txtName.getText().trim();
				String userPwd = txtPwd.getText().trim();
//				if (userId < 999999999 && userId > 0 && userName.length() > 0 && userName.length() < 10
//						&& userPwd.length() > 0 && userPwd.length() < 10) {
				int flag = AdminDao.updateUsr(userId, userName, userPwd);
				if (flag == 0) {
					JOptionPane.showMessageDialog(null, "修改成功！");
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
//				}else {
//						JOptionPane.showMessageDialog(null, "数据不合法！");
//				}
			}
		});
		btnSub.setBounds(57, 267, 97, 23);
		getContentPane().add(btnSub);

		JButton btnExit = new JButton("\u53D6\u6D88");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditUserFrame.this.setVisible(false);
			}
		});
		btnExit.setBounds(164, 267, 97, 23);
		getContentPane().add(btnExit);

		txtPwd = new JPasswordField();
		txtPwd.setBounds(136, 192, 122, 21);
		getContentPane().add(txtPwd);

	}
}
