package interfaces;

import dbadapter.userbean;

public interface IUserdatbase {
	
	public boolean get_Username(String name, String email, int age);
	public userbean CreatingAccount(String username,String Email,int age);

}
