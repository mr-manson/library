package by.htp.library.dao;

import java.io.FileNotFoundException;

import by.htp.library.bean.User;

public interface UserDao {
	
	boolean authorization(String login, String password) throws  DaoException, FileNotFoundException ;
	boolean registration(User newUser) throws  DaoException, FileNotFoundException ;
	boolean changeUserStatus(int idUser, String newStatus) throws  DaoException ;

}
