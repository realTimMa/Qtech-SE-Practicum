package cn.qdlgdx.service;

import cn.qdlgdx.dao.SecretaryDao;

/**
 * 
 * @author Tim Ma
 *
 */
public class SecretarService {
	SecretaryDao secretarDao = new SecretaryDao();

	public int taskInput(String taskPath) {
		// TODO Auto-generated method stub
		return secretarDao.taskInput(taskPath);
	}

}
