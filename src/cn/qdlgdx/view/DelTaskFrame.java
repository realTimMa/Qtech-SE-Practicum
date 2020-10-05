package cn.qdlgdx.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.qdlgdx.dao.AdminDao;
import cn.qdlgdx.dao.SecretaryDao;

/**
 * 
 * @author Tim Ma
 *
 */
public class DelTaskFrame extends JInternalFrame {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtCate;
	private JTextField txtDept;
	private JTextField txtPrcp;
	private JTextField txtPfmc;
	private JTextField txtAsstt;
	private JTextField txtGrade;
	private JTextField txtWeight;
	private JTextField txtJan;
	private JTextField txtFeb;
	private JTextField txtMar;
	private JTextField txtApr;
	private JTextField txtMay;
	private JTextField txtJun;
	private JTextField txtJul;
	private JTextField txtAug;
	private JTextField txtSept;
	private JTextField txtOct;
	private JTextField txtNov;
	private JTextField txtDec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTaskFrame frame = new AddTaskFrame();
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
	public DelTaskFrame() {
		setTitle("\u5220\u9664\u4EFB\u52A1");
		setBounds(100, 100, 850, 500);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(31, 31, 58, 15);
		getContentPane().add(lblNewLabel);

		txtId = new JTextField();
		txtId.setBounds(99, 28, 102, 21);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u4EFB\u52A1\u540D\uFF1A");
		lblNewLabel_1.setBounds(31, 66, 58, 15);
		getContentPane().add(lblNewLabel_1);

		txtName = new JTextField();
		txtName.setBounds(99, 63, 102, 21);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u5C5E\u6027\uFF1A");
		lblNewLabel_2.setBounds(31, 97, 58, 15);
		getContentPane().add(lblNewLabel_2);

		txtCate = new JTextField();
		txtCate.setBounds(99, 94, 102, 21);
		getContentPane().add(txtCate);
		txtCate.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u8D23\u4EFB\u90E8\u95E8\uFF1A");
		lblNewLabel_3.setBounds(31, 159, 69, 15);
		getContentPane().add(lblNewLabel_3);

		txtDept = new JTextField();
		txtDept.setBounds(99, 153, 102, 21);
		getContentPane().add(txtDept);
		txtDept.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u8D23\u4EFB\u4EBA\uFF1A");
		lblNewLabel_4.setBounds(31, 187, 58, 15);
		getContentPane().add(lblNewLabel_4);

		txtPrcp = new JTextField();
		txtPrcp.setBounds(99, 184, 102, 21);
		getContentPane().add(txtPrcp);
		txtPrcp.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u534F\u529E\u4EBA\uFF1A");
		lblNewLabel_5.setBounds(31, 218, 58, 15);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u5B8C\u6210\u60C5\u51B5\uFF1A");
		lblNewLabel_6.setBounds(31, 274, 69, 15);
		getContentPane().add(lblNewLabel_6);

		txtPfmc = new JTextField();
		txtPfmc.setBounds(99, 271, 102, 21);
		getContentPane().add(txtPfmc);
		txtPfmc.setColumns(10);

		txtAsstt = new JTextField();
		txtAsstt.setBounds(99, 215, 102, 21);
		getContentPane().add(txtAsstt);
		txtAsstt.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("\u5206\u503C\uFF1A");
		lblNewLabel_7.setBounds(31, 299, 58, 15);
		getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\u6743\u91CD\uFF1A");
		lblNewLabel_8.setBounds(31, 324, 58, 15);
		getContentPane().add(lblNewLabel_8);

		txtGrade = new JTextField();
		txtGrade.setBounds(99, 299, 102, 21);
		getContentPane().add(txtGrade);
		txtGrade.setColumns(10);

		txtWeight = new JTextField();
		txtWeight.setBounds(99, 324, 102, 21);
		getContentPane().add(txtWeight);
		txtWeight.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("\u4E00\u6708\uFF1A");
		lblNewLabel_9.setBounds(420, 31, 58, 15);
		getContentPane().add(lblNewLabel_9);

		txtJan = new JTextField();
		txtJan.setBounds(488, 28, 102, 21);
		getContentPane().add(txtJan);
		txtJan.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("\u4E8C\u6708\uFF1A");
		lblNewLabel_10.setBounds(420, 69, 58, 15);
		getContentPane().add(lblNewLabel_10);

		txtFeb = new JTextField();
		txtFeb.setBounds(488, 63, 102, 21);
		getContentPane().add(txtFeb);
		txtFeb.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("\u4E09\u6708\uFF1A");
		lblNewLabel_11.setBounds(420, 97, 58, 15);
		getContentPane().add(lblNewLabel_11);

		txtMar = new JTextField();
		txtMar.setBounds(488, 94, 102, 21);
		getContentPane().add(txtMar);
		txtMar.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("\u56DB\u6708\uFF1A");
		lblNewLabel_12.setBounds(420, 159, 58, 15);
		getContentPane().add(lblNewLabel_12);

		txtApr = new JTextField();
		txtApr.setBounds(488, 156, 102, 21);
		getContentPane().add(txtApr);
		txtApr.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("\u4E94\u6708\uFF1A");
		lblNewLabel_13.setBounds(420, 187, 58, 15);
		getContentPane().add(lblNewLabel_13);

		txtMay = new JTextField();
		txtMay.setText("");
		txtMay.setBounds(488, 184, 102, 21);
		getContentPane().add(txtMay);
		txtMay.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("\u516D\u6708\uFF1A");
		lblNewLabel_14.setBounds(420, 218, 58, 15);
		getContentPane().add(lblNewLabel_14);

		txtJun = new JTextField();
		txtJun.setBounds(488, 215, 102, 21);
		getContentPane().add(txtJun);
		txtJun.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("\u4E03\u6708\uFF1A");
		lblNewLabel_15.setBounds(420, 274, 58, 15);
		getContentPane().add(lblNewLabel_15);

		txtJul = new JTextField();
		txtJul.setBounds(488, 271, 102, 21);
		getContentPane().add(txtJul);
		txtJul.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("\u516B\u6708\uFF1A");
		lblNewLabel_16.setBounds(420, 302, 58, 15);
		getContentPane().add(lblNewLabel_16);

		txtAug = new JTextField();
		txtAug.setBounds(488, 296, 102, 21);
		getContentPane().add(txtAug);
		txtAug.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("\u4E5D\u6708\uFF1A");
		lblNewLabel_17.setBounds(420, 324, 58, 15);
		getContentPane().add(lblNewLabel_17);

		txtSept = new JTextField();
		txtSept.setBounds(488, 321, 102, 21);
		getContentPane().add(txtSept);
		txtSept.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("\u5341\u6708\uFF1A");
		lblNewLabel_18.setBounds(420, 370, 58, 15);
		getContentPane().add(lblNewLabel_18);

		txtOct = new JTextField();
		txtOct.setBounds(488, 367, 102, 21);
		getContentPane().add(txtOct);
		txtOct.setColumns(10);

		JLabel lblNewLabel_19 = new JLabel("\u5341\u4E00\u6708\uFF1A");
		lblNewLabel_19.setBounds(420, 395, 58, 15);
		getContentPane().add(lblNewLabel_19);

		txtNov = new JTextField();
		txtNov.setBounds(488, 392, 102, 21);
		getContentPane().add(txtNov);
		txtNov.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("\u5341\u4E8C\u6708\uFF1A");
		lblNewLabel_20.setBounds(420, 420, 58, 15);
		getContentPane().add(lblNewLabel_20);

		txtDec = new JTextField();
		txtDec.setBounds(488, 417, 102, 21);
		getContentPane().add(txtDec);
		txtDec.setColumns(10);

		JButton btnSub = new JButton("\u786E\u8BA4");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int taskId = Integer.parseInt(txtId.getText().trim());
				int flag = SecretaryDao.deleteTask(taskId);
				if (flag == 0) {
					JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦£¡");
				} else {
					JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü£¡");
				}
			}
		});
		btnSub.setBounds(31, 391, 97, 23);
		getContentPane().add(btnSub);

		JButton btnExit = new JButton("\u53D6\u6D88");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelTaskFrame.this.setVisible(false);
			}
		});
		btnExit.setBounds(180, 391, 97, 23);
		getContentPane().add(btnExit);

		JButton btnSearch = new JButton("\u67E5\u8BE2");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText().trim();
				String[] tsk = null;
				tsk = SecretaryDao.selectTask(id);
				txtId.setText(tsk[0]);
				txtName.setText(tsk[1]);
				txtCate.setText(tsk[2]);
				txtJan.setText(tsk[3]);
				txtFeb.setText(tsk[4]);
				txtMar.setText(tsk[5]);
				txtApr.setText(tsk[6]);
				txtMay.setText(tsk[7]);
				txtJun.setText(tsk[8]);
				txtJul.setText(tsk[9]);
				txtAug.setText(tsk[10]);
				txtSept.setText(tsk[11]);
				txtOct.setText(tsk[12]);
				txtNov.setText(tsk[13]);
				txtDec.setText(tsk[14]);
				txtDept.setText(tsk[15]);
				txtPrcp.setText(tsk[16]);
				txtAsstt.setText(tsk[17]);
				txtPfmc.setText(tsk[18]);
				txtGrade.setText(tsk[19]);
				txtWeight.setText(tsk[20]);
			}
		});
		btnSearch.setBounds(240, 27, 97, 23);
		getContentPane().add(btnSearch);

	}

}
