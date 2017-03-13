package www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import www.bean.Film;
import www.bean.User_load;



/**
 * Oracle���ݿ�jdbc������
 * 
 * @author Administrator
 * 
 */
public class Load_dao {

	private static final String id = null;
	// ���ݿ������ࡣ
	private String dbDriver = "com.mysql.jdbc.Driver";
	// �������ݿ�url��ip:�˿�:���ݿ���
	private String dbURL = "jdbc:mysql://localhost:3306/sakila";
	// �������ݿ��û�����
	private String dbUser = "root";
	// �������ݿ����롣
	private String dbPwd = "xiaoroot";
	// ��ȡ���ݿ����ӷ���, ����Connection����
	private Connection con = null;
	// ����ִ����䡣
	private Statement stat = null;
	// �����
	private ResultSet rs = null;

	/**
	 * �õ�oracle���ݿ�����ӡ�
	 * 
	 * @return ����
	 */
	@SuppressWarnings("finally")
	public Connection getConnect() {
		try {
			Class.forName(dbDriver);
			// ͨ��DriverManager�õ����ӡ�
			con = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return con;
		}
	}
   //public abstract List searchfilm(Object obj��String sql);
   //public abstract List addfilm(Object obj��String sql);
	//public abstract List updatefilm(Object obj��String sql);
	//��ѯҪ��ʾ�ı�
	@SuppressWarnings("finally")
	public List<User_load> search1(String sql) {
		con = getConnect();// ������ӡ�
		// �������sql��䡣
		System.out.println(sql);
		ArrayList<User_load> list_user = null;// ����һ��װ�ر�����������
		try {
			stat = con.createStatement();// ����ִ�С�
			rs = stat.executeQuery(sql);// ִ�С�
			list_user = new ArrayList<User_load>();// ����һ��װ�ر�����������
			while (rs.next()) {// ������
				User_load us = new User_load();//������Ӧ��ʵ�塣
			
				
				us.setName(rs.getString("name"));// ����������
				us.setPassword(rs.getString( "pwd"));
			
				list_user.add(us);// װ��������
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
			return list_user;
		}
	}

	//��½��ѯ
	@SuppressWarnings("finally")
	public List<Film> search(String sql) {
		con = getConnect();// ������ӡ�
		// �������sql��䡣
		//System.out.println(sql);
		ArrayList<Film> list_user = null;// ����һ��װ�ر�����������
		try {
			stat = con.createStatement();// ����ִ�С�
			rs = stat.executeQuery(sql);// ִ�С�
			list_user = new ArrayList<Film>();// ����һ��װ�ر�����������
			while (rs.next()) {// ������
				Film us = new Film();//������Ӧ��ʵ�塣
			
				us.setFilm_id(rs.getInt("film_id"));
				us.setTitle(rs.getString("Title"));// ����������
				us.setDescription(rs.getString("description;"));
				us.setLanguage(rs.getInt("language"));
				list_user.add(us);// װ��������
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
			return list_user;
		}
	}
	
	
	/**
	 * ����:�ر����ݿ������
	 */
	public void close() { // �ͷ���Դ
		try { // ��׽�쳣
			try {
				if (rs != null) { // ��ResultSet�����ʵ��rs��Ϊ��ʱ
					rs.close(); // �ر�ResultSet����
				}
			} finally {
				try {
					if (stat != null) { // ��Statement�����ʵ��stmt��Ϊ��ʱ
						stat.close(); // �ر�Statement����
					}
				} finally {
					if (con != null) { // ��Connection�����ʵ��conn��Ϊ��ʱ
						con.close(); // �ر�Connection����
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err); // ����쳣��Ϣ
		}
	}
}
