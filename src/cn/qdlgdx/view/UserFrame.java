package cn.qdlgdx.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Tim Ma
 *
 */
public class UserFrame extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane;
	private String usrId;
	private String usrName;
	private String usrPwd;
	private String usrLvl;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserFrame frame = new UserFrame("1", "user", "1", "Ô±¹¤");
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
	public UserFrame(String usrId, String usrName, String usrPwd,String usrLvl) {
		setTitle("\u5458\u5DE5\u754C\u9762");
		this.usrId = usrId;
		this.usrName = usrName;
		this.usrPwd = usrPwd;
		this.usrLvl=usrLvl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u4E2A\u4EBA\u4FE1\u606F");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u5BC6\u7801\u4FEE\u6539");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				EditUserPwd eu = new EditUserPwd(usrId, usrName);
				((javax.swing.plaf.basic.BasicInternalFrameUI) eu.getUI()).setNorthPane(null);
				eu.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);

				desktopPane.add(eu);
				eu.setVisible(true);
				try {
					eu.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("\u4EFB\u52A1\u4FE1\u606F");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmAddTask = new JMenuItem("\u67E5\u770B\u4EFB\u52A1\u4FE1\u606F");
		mntmAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTaskFrame st = new ShowTaskFrame();
				((javax.swing.plaf.basic.BasicInternalFrameUI) st.getUI()).setNorthPane(null);
				st.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);

				desktopPane.add(st);
				st.setVisible(true);
				try {
					st.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		mnNewMenu_1.add(mntmAddTask);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7F16\u8F91\u5B8C\u6210\u60C5\u51B5");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserEditTask ue = new UserEditTask(usrName);
				((javax.swing.plaf.basic.BasicInternalFrameUI) ue.getUI()).setNorthPane(null);
				ue.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);

				desktopPane.add(ue);
				ue.setVisible(true);
				try {
					ue.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		ImageIcon imageIcon = new ImageIcon("img/pic.jpg");
		
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u60A8\uFF0C");
		lblNewLabel.setBounds(266, 220, 58, 15);
		desktopPane.add(lblNewLabel);
		
		JLabel lblWelcome = new JLabel("");
		lblWelcome.setBounds(334, 220, 202, 15);
		desktopPane.add(lblWelcome);
		lblWelcome.setText(usrName);
		
		JLabel lblNewLabel_1 = new JLabel("\u73B0\u5728\u662F\uFF1A");
		lblNewLabel_1.setBounds(266, 245, 58, 15);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblTime = new JLabel("");
		lblTime.setBounds(334, 245, 202, 15);
		desktopPane.add(lblTime);
		lblTime.setText(new Date().toLocaleString());
		
		JLabel lblNewLabel_2 = new JLabel("\u60A8\u7684\u6743\u9650\u4E3A\uFF1A");
		lblNewLabel_2.setBounds(266, 270, 80, 15);
		desktopPane.add(lblNewLabel_2);
		
		JLabel lblLvl = new JLabel("");
		lblLvl.setBounds(343, 270, 193, 15);
		desktopPane.add(lblLvl);
		lblLvl.setText(usrLvl);
	}
}
