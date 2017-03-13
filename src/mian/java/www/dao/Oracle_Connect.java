package www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;






/**
 * Oracle���ݿ�jdbc������
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("unused")
public abstract class Oracle_Connect{

	private static final String id = null;
	// ���ݿ������ࡣ
	private String dbDriver = "com.mysql.jdbc.Driver";
	// �������ݿ�url��ip:�˿�:���ݿ���
	private String dbURL = "jdbc:mysql://localhost:3306/saklia";
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
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ͨ��DriverManager�õ����ӡ�
			con = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return con;
		}
	}

//	/**
//	 * ����
//	 * @param us MY_Userһ��ʵ�����
//	 * @return Ӱ��������
//	 */
//	@SuppressWarnings("finally")
//	public int add(My_User us) {
//		int row = 0 ;
//		con = getConnect();// ��ȥ����д�õ����ӷ�����
//		try {
//			sql = "insert into my_user(name,age,addr,subject,num) "
//					+ "values('"+us.getName()+"',"+us.getAge()+",'"+us.getAddr()+"','"+us.getSubj()+"',"+us.getNum()+")";
//			stat = con.createStatement();// ���Ӷ��󴴽�statement��
//			row = stat.executeUpdate(sql);// ��ɾ�ķ�����
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			return row;
//		}
//	}

//	/**
//	 * ����id������Ҫɾ���е�������
//	 * ɾ����
//	 */
//	@SuppressWarnings("finally")
//	public int dels(int id) {
//		int row = 0;
//		con = getConnect();// ��ȥ����д�õ����ӷ�����
//		try {
//			sql = "delete from my_user  where id =  "+id;
//			stat = con.createStatement();// ���Ӷ��󴴽�statement��
//			row = stat.executeUpdate(sql);// ��ɾ�ķ�����
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			return row ;
//		}
//	}

	
//	 /**
//	  * �޸�
//	  * @param id ������
//	  * @param what �޸ĵ��ַ������ݡ�
//	  * @return Ӱ���������
//	  */
//	@SuppressWarnings("finally")
//	public int update(int id , String what) {
//		int row = 0 ;
//		con = getConnect();// ��ȥ����д�õ����ӷ�����
//		sql = "update my_user set";
//		try {
//			sql = "update my_user set addr ='"+what+"' where id = "+id;
//			System.out.println(sql);
//			stat = con.createStatement();// ���Ӷ��󴴽�statement��
//			row = stat.executeUpdate(sql);// ��ɾ�ķ�����
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			return row ;
//		}
//	}

//	/**
//	 * 
//	 * @return ����My_user����
//	 */
//	@SuppressWarnings("finally")
//	public List<My_User> search(int pageNum ,int size) {
//		con = getConnect();// ������ӡ�
//		// �������sql��䡣
//		sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN "+
//		"FROM (SELECT * FROM my_user) A WHERE ROWNUM <= "+pageNum*size+" ) WHERE RN > "+(pageNum-1)*size;
//		System.out.println(sql);
//		ArrayList<My_User> list_user = null;// ����һ��װ�ر�����������
//		try {
//			stat = con.createStatement();// ����ִ�С�
//			rs = stat.executeQuery(sql);// ִ�С�
//			list_user = new ArrayList<My_User>();// ����һ��װ�ر�����������
//			while (rs.next()) {// ������
//				My_User us = new My_User();//������Ӧ��ʵ�塣
//				
//				us.setId(rs.getInt("id"));// ���ñ�š�
//				us.setName(rs.getString("name"));// ����������
//				us.setAge(rs.getInt("age"));// �������䡣
//				us.setAddr(rs.getString("addr"));// ����סַ��
//				us.setSubj(rs.getString("subject"));// ����ѧ�ơ�
//				us.setNum(rs.getInt("num"));// ���÷�����
//			
//				list_user.add(us);// װ��������
//				
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			return list_user;
//		}
//	}

	/**
	 * ��ѯ�û�
	 * @param obj ���Ķ���
	 * @param sql sql��䡣
	 * @return װ�������û��ļ���
	 */
	public abstract List search(Object obj,String sql);
	
	/**
	 * ɾ��
	 * @param sql sql��䡣
	 * @return ��ɾ���ļ��С�
	 */
	public abstract int delect(String sql);
	
	/**
	 * ���
	 * @param sql sql��䡣
	 * @return ����˼��У�
	 */
	public abstract int add(String sql);
	
	/**
	 * �޸�
	 * @param sql sql��䡣
	 * @return �޸��˼��У�
	 */
	public abstract int update(String sql);
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
