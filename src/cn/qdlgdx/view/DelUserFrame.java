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
public class DelUserFrame extends JInternalFrame {
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
					DelUserFrame frame = new DelUserFrame();
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
	public DelUserFrame() {
		setTitle("\u5220\u9664\u7528\u6237");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(63, 36, 58, 15);
		getContentPane().add(lblNewLabel);

		txtSearch = new JTextField();
		txtSearch.setBounds(165, 33, 101, 21);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setBounds(63, 86, 58, 15);
		getContentPane().add(lblNewLabel_1);

		txtId = new JTextField();
		txtId.setBounds(165, 83, 101, 21);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_2.setBounds(63, 121, 58, 15);
		getContentPane().add(lblNewLabel_2);

		txtName = new JTextField();
		txtName.setBounds(165, 118, 101, 21);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setBounds(63, 152, 58, 15);
		getContentPane().add(lblNewLabel_3);

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
		btnSearch.setBounds(308, 32, 97, 23);
		getContentPane().add(btnSearch);

		JButton btnSub = new JButton("\u5220\u9664");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userDel = Integer.parseInt(txtSearch.getText().trim());
				int userId = Integer.parseInt(txtId.getText().trim());
				if (userDel == userId) {
					int flag = AdminDao.deleteUsr(userId);
					if (flag == 0) {
						JOptionPane.showMessageDialog(null, "删除成功！");
					} else {
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				} else {
					JOptionPane.showMessageDialog(null, "两次输入不一致！");
				}
			}
		});
		btnSub.setBounds(63, 199, 97, 23);
		getContentPane().add(btnSub);

		JButton btnExit = new JButton("\u53D6\u6D88");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelUserFrame.this.setVisible(false);
			}
		});
		btnExit.setBounds(216, 199, 97, 23);
		getContentPane().add(btnExit);

		txtPwd = new JPasswordField();
		txtPwd.setBounds(165, 149, 101, 21);
		getContentPane().add(txtPwd);

	}
}
