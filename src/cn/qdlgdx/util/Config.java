package cn.qdlgdx.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Tim Ma
 *
 */
//������
public class Config {
	private static Properties p = null;
	static {
		try {
			p = new Properties();
			// ���������ļ�
			p.load(new FileInputStream("config/mysql.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ȡ����Ӧ��ֵ
	public static String getValue(String key) {
		return p.get(key).toString();
	}
}
