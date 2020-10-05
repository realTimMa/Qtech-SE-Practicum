package cn.qdlgdx.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

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
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

/**
 * 
 * @author Tim Ma
 *
 */
public class AdminFrame extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane;
	private String admName;
	private String admPwd;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminFrame frame = new AdminFrame("adm", "123");
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
	public AdminFrame(String admName, String admPwd) {
		setTitle("\u7BA1\u7406\u5458\u754C\u9762");
		this.admName = admName;
		this.admPwd = admPwd;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u5458\u5DE5\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAddUsr = new JMenuItem("\u6DFB\u52A0\u5458\u5DE5\u4FE1\u606F");
		mntmAddUsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUserFrame ad = new AddUserFrame();
				((javax.swing.plaf.basic.BasicInternalFrameUI) ad.getUI()).setNorthPane(null);
				ad.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);

				desktopPane.add(ad);
				ad.setVisible(true);
				try {
					ad.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmAddUsr);

		JMenuItem mntmEditUsr = new JMenuItem("\u4FEE\u6539\u5458\u5DE5\u4FE1\u606F");
		mntmEditUsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditUserFrame ed = new EditUserFrame();
				((javax.swing.plaf.basic.BasicInternalFrameUI) ed.getUI()).setNorthPane(null);
				ed.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);

				desktopPane.add(ed);
				ed.setVisible(true);
				try {
					ed.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmEditUsr);

		JMenuItem mntmDelUsr = new JMenuItem("\u5220\u9664\u5458\u5DE5\u4FE1\u606F");
		mntmDelUsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelUserFrame de = new DelUserFrame();
				((javax.swing.plaf.basic.BasicInternalFrameUI) de.getUI()).setNorthPane(null);
				de.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);

				desktopPane.add(de);
				de.setVisible(true);
				try {
					de.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmDelUsr);

		JMenu mnNewMenu_1 = new JMenu("\u4EFB\u52A1\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmAddTask = new JMenuItem("\u4FEE\u6539\u4EFB\u52A1\u4FE1\u606F");
		mntmAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTaskFrame et = new EditTaskFrame();
				((javax.swing.plaf.basic.BasicInternalFrameUI) et.getUI()).setNorthPane(null);
				et.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);

				desktopPane.add(et);
				et.setVisible(true);
				try {
					et.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		mnNewMenu_1.add(mntmAddTask);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("\u60A8\u597D\uFF0C\u5C0A\u656C\u7684");
		lblNewLabel.setBounds(229, 185, 90, 15);
		desktopPane.add(lblNewLabel);

		JLabel lblName = new JLabel("");
		lblName.setBounds(329, 185, 174, 15);
		desktopPane.add(lblName);
		lblName.setText(admName);
		lblName.setForeground(Color.RED);

		JLabel lblNewLabel_2 = new JLabel("\u73B0\u5728\u662F:");
		lblNewLabel_2.setBounds(229, 216, 58, 15);
		desktopPane.add(lblNewLabel_2);

		JLabel lblTime = new JLabel("");
		lblTime.setBounds(329, 216, 154, 15);
		desktopPane.add(lblTime);
		lblTime.setText(new Date().toLocaleString());

		JLabel lblNewLabel_4 = new JLabel("\u60A8\u7684\u6743\u9650\u4E3A\uFF1A");
		lblNewLabel_4.setBounds(229, 251, 84, 15);
		desktopPane.add(lblNewLabel_4);

		JLabel lblAdm = new JLabel("\u7BA1\u7406\u5458");
		lblAdm.setBounds(327, 250, 122, 15);
		desktopPane.add(lblAdm);
		lblAdm.setText("π‹¿Ì‘±");
		lblAdm.setForeground(Color.BLUE);
	}
}
