package www.bean;

/**
 * 登录信息员。
 * 
 * @author Administrator
 * 
 */
public class User_load {
	private int id;
	private String name;// 用户名。
	private String pwd;// 密码。
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return pwd;
	}
	public void setPassword(String password) {
		this.pwd = password;
	}
	public User_load(int id, String name, String password) {
		
		this.id = id;
		this.name = name;
		this.pwd = password;
	}
	public User_load() {
		
	}
	
	


}
