package by.htp.library.dao.impl;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.UserDao;

public class FileUserDao implements UserDao {

	@Override
	public boolean authorization(String login, String password) throws FileNotFoundException {
		List<User> users = getDataFromFile();

		for (User user : users) {
			if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean registration(User newUser) throws DaoException, FileNotFoundException {
		List<User> users = getDataFromFile();
		int newId = users.get(0).getId();
		for (User user : users) {
			if (newId < user.getId()) {
				newId = user.getId();
			}
			
		}
		try {
			FileWriter writer = new FileWriter("users.txt");
			String login = newUser.getLogin();
			String password = newUser.getPassword();
			
			String str = "\nid=" + (newId + 1) + " " + "login=" + login + " " + "password=" + password;
			writer.write(str);
			writer.flush();
			writer.close();
						

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

	private List<User> getDataFromFile() throws FileNotFoundException {
		List<User> users = new ArrayList<User>();
		FileReader reader = new FileReader("users.txt");
		Scanner sc = new Scanner(reader);

		while (sc.hasNextLine()) {
			String u = sc.nextLine();
			int id = Integer.parseInt(u.substring(3, 4));
			String log = u.substring(11, 16);
			String pass = u.substring(26, 30);
			User user = new User(id, log, pass);
			users.add(user);
		}
		sc.close();
		return users;
	}

}
