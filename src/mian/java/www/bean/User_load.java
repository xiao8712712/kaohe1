package www.bean;

/**
 * ��¼��ϢԱ��
 * 
 * @author Administrator
 * 
 */
public class User_load {
	private int id;
	private String name;// �û�����
	private String pwd;// ���롣
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
