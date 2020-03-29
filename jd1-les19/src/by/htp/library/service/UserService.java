package by.htp.library.service;

import java.io.FileNotFoundException;

import by.htp.library.bean.User;

public interface UserService {
	
	boolean authorization(String login, String password)  throws ServiceException, FileNotFoundException;
	void registration(User user)  throws ServiceException;

}
