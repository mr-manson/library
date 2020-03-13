package by.htp.library.dao.impl;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.UserDao;

public class FileUserDao implements UserDao {

	@SuppressWarnings("resource")
	@Override
	public boolean authorization(String login, String password) throws DaoException {
		try {
			FileReader reader = new FileReader("users.txt");
			Scanner sc = new Scanner(reader);
			
			// получить строку из users.txt, распарсить, получить хранящиеся в ней логин и пароль и сохранить в строки:
			String loginSaved = "qqq";
			String passwordSaved = "www";
			
			if(login.equals(loginSaved) && password.equals(passwordSaved)) {
				System.out.println("Authorization sucssesful");
				return true;
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;

		
	}

	@Override
	public boolean registration(User newUser) throws DaoException {
		try {
			FileWriter writer = new FileWriter("");
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return false;
	}

	@Override
	public boolean changeUserStatus(int idUser, String newStatus) {
		// TODO Auto-generated method stub
		return false;
	}

}
