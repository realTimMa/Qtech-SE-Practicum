package cn.qdlgdx.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.qdlgdx.dao.UserDao;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 * @author Tim Ma
 *
 */
public class ShowTaskFrame extends JInternalFrame {

	UserDao UserDao = new UserDao();
	private JPanel panel;
	private JButton btnSub;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtId;
	private JLabel lblNewLabel;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowTaskFrame frame = new ShowTaskFrame();
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
	public ShowTaskFrame() {
		setTitle("\u663E\u793A\u4EFB\u52A1");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		btnSub = new JButton("\u786E\u8BA4");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tskId = txtId.getText().trim();
//				if (tskId.length() > 0 && tskId.length() < 10) {
				ArrayList<String[]> list = UserDao.selectTsk(tskId);
				DefaultTableModel tm = (DefaultTableModel) table.getModel();
				for (String[] r : list) {
					tm.addRow(r);
				}
//				} else {
//					JOptionPane.showMessageDialog(null, "数据不合法！");
//				}

			}
		});

		lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		panel.add(lblNewLabel);

		txtId = new JTextField();
		panel.add(txtId);
		txtId.setColumns(10);
		panel.add(btnSub);

		btnExit = new JButton("\u53D6\u6D88");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTaskFrame.this.setVisible(false);
			}
		});
		panel.add(btnExit);

		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5E8F\u53F7", "\u4EFB\u52A1\u540D", "\u4EFB\u52A1\u5C5E\u6027", "1\u6708", "2\u6708",
						"3\u6708", "4\u6708", "5\u6708", "6\u6708", "7\u6708", "8\u6708", "9\u6708", "10\u6708",
						"11\u6708", "12\u6708", "\u8D23\u4EFB\u90E8\u95E8", "\u8D23\u4EFB\u4EBA", "\u534F\u529E\u4EBA",
						"\u5B8C\u6210\u60C5\u51B5", "\u5206\u503C", "\u6743\u91CD" }));
		scrollPane.setViewportView(table);

	}

}
