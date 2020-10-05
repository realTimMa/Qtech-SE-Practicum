package cn.qdlgdx.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Tim Ma
 *
 */
public class SecretaryFrame extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane;
	private String secName;
	private String secPwd;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SecretaryFrame frame = new SecretaryFrame("sec", "123");
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
	public SecretaryFrame(String secName, String secPwd) {
		setTitle("\u79D8\u4E66\u754C\u9762");
		this.secName = secName;
		this.secPwd = secPwd;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu_1 = new JMenu("\u4EFB\u52A1\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmAddTask = new JMenuItem("\u6DFB\u52A0\u4EFB\u52A1\u4FE1\u606F");
		mntmAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTaskFrame at = new AddTaskFrame();
				((javax.swing.plaf.basic.BasicInternalFrameUI) at.getUI()).setNorthPane(null);
				at.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);

				desktopPane.add(at);
				at.setVisible(true);
				try {
					at.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		mnNewMenu_1.add(mntmAddTask);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u5220\u9664\u4EFB\u52A1\u4FE1\u606F");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelTaskFrame dt = new DelTaskFrame();
				((javax.swing.plaf.basic.BasicInternalFrameUI) dt.getUI()).setNorthPane(null);
				dt.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);

				desktopPane.add(dt);
				dt.setVisible(true);
				try {
					dt.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u60A8\u597D\uFF0C");
		lblNewLabel.setBounds(231, 189, 58, 15);
		desktopPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(302, 189, 146, 15);
		desktopPane.add(lblName);
		lblName.setText(secName);
		
		JLabel lblNewLabel_1 = new JLabel("\u73B0\u5728\u662F\uFF1A");
		lblNewLabel_1.setBounds(231, 224, 80, 15);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblTime = new JLabel("");
		lblTime.setBounds(302, 224, 146, 15);
		desktopPane.add(lblTime);
		lblTime.setText(new Date().toLocaleString());
		
		JLabel lblNewLabel_2 = new JLabel("\u60A8\u7684\u6743\u9650\u4E3A\uFF1A \u79D8\u4E66");
		lblNewLabel_2.setBounds(231, 262, 202, 15);
		desktopPane.add(lblNewLabel_2);
	}
}
