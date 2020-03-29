package by.htp.library.dao.impl;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String str = "id=1 login=vasay password=1234 role=admin";
		String id = str.substring(3,4);
		String login = str.substring(11,16);
		String password = str.substring(26,30);
		System.out.println(id + " " + login + " " + password);
		
		
		
		//for(String s : a) {
		//	System.out.println(s + " ");
		//}
		
	}

}
