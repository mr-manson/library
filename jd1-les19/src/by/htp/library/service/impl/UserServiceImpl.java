package by.htp.library.service.impl;

import java.io.FileNotFoundException;

import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.DaoProvider;
import by.htp.library.dao.UserDao;
import by.htp.library.dao.impl.FileUserDao;
import by.htp.library.service.ServiceException;
import by.htp.library.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean authorization(String login, String password) throws ServiceException, FileNotFoundException {
		if (login == null || login.isEmpty()) {
			throw new RuntimeException("error");// stub
		}
		if (password == null || password.isEmpty()) {
			throw new RuntimeException("error");
		}

		boolean result;

		DaoProvider provider = DaoProvider.getInstance();
		UserDao userDao = provider.getUserDao();
		try {
			result = userDao.authorization(login, password);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;

	}

	@Override
	public void registration(User user) {
		// TODO Auto-generated method stub

	}

}
