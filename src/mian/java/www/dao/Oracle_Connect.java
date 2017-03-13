package www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;






/**
 * Oracle数据库jdbc操作。
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("unused")
public abstract class Oracle_Connect{

	private static final String id = null;
	// 数据库驱动类。
	private String dbDriver = "com.mysql.jdbc.Driver";
	// 连接数据库url。ip:端口:数据库名
	private String dbURL = "jdbc:mysql://localhost:3306/saklia";
	// 连接数据库用户名。
	private String dbUser = "root";
	// 连接数据库密码。
	private String dbPwd = "xiaoroot";
	// 获取数据库连接方法, 返回Connection对象。
	private Connection con = null;
	// 数据执行语句。
	private Statement stat = null;
	// 结果。
	private ResultSet rs = null;

	/**
	 * 得到oracle数据库的链接。
	 * 
	 * @return 链接
	 */
	@SuppressWarnings("finally")
	public Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 通过DriverManager得到链接。
			con = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return con;
		}
	}

//	/**
//	 * 新增
//	 * @param us MY_User一个实体对象。
//	 * @return 影响行数。
//	 */
//	@SuppressWarnings("finally")
//	public int add(My_User us) {
//		int row = 0 ;
//		con = getConnect();// 调去我们写好的链接方法。
//		try {
//			sql = "insert into my_user(name,age,addr,subject,num) "
//					+ "values('"+us.getName()+"',"+us.getAge()+",'"+us.getAddr()+"','"+us.getSubj()+"',"+us.getNum()+")";
//			stat = con.createStatement();// 链接对象创建statement。
//			row = stat.executeUpdate(sql);// 增删改方法。
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			return row;
//		}
//	}

//	/**
//	 * 参数id是我们要删除行的主键。
//	 * 删除。
//	 */
//	@SuppressWarnings("finally")
//	public int dels(int id) {
//		int row = 0;
//		con = getConnect();// 调去我们写好的链接方法。
//		try {
//			sql = "delete from my_user  where id =  "+id;
//			stat = con.createStatement();// 链接对象创建statement。
//			row = stat.executeUpdate(sql);// 增删改方法。
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			return row ;
//		}
//	}

	
//	 /**
//	  * 修改
//	  * @param id 主键。
//	  * @param what 修改的字符串内容。
//	  * @return 影响的行数。
//	  */
//	@SuppressWarnings("finally")
//	public int update(int id , String what) {
//		int row = 0 ;
//		con = getConnect();// 调去我们写好的链接方法。
//		sql = "update my_user set";
//		try {
//			sql = "update my_user set addr ='"+what+"' where id = "+id;
//			System.out.println(sql);
//			stat = con.createStatement();// 链接对象创建statement。
//			row = stat.executeUpdate(sql);// 增删改方法。
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			return row ;
//		}
//	}

//	/**
//	 * 
//	 * @return 返回My_user对象。
//	 */
//	@SuppressWarnings("finally")
//	public List<My_User> search(int pageNum ,int size) {
//		con = getConnect();// 获得链接。
//		// 创建表的sql语句。
//		sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN "+
//		"FROM (SELECT * FROM my_user) A WHERE ROWNUM <= "+pageNum*size+" ) WHERE RN > "+(pageNum-1)*size;
//		System.out.println(sql);
//		ArrayList<My_User> list_user = null;// 创建一个装载表对象的容器。
//		try {
//			stat = con.createStatement();// 建立执行。
//			rs = stat.executeQuery(sql);// 执行。
//			list_user = new ArrayList<My_User>();// 创建一个装载表对象的容器。
//			while (rs.next()) {// 迭代。
//				My_User us = new My_User();//表对象对应的实体。
//				
//				us.setId(rs.getInt("id"));// 设置编号。
//				us.setName(rs.getString("name"));// 设置姓名。
//				us.setAge(rs.getInt("age"));// 设置年龄。
//				us.setAddr(rs.getString("addr"));// 设置住址。
//				us.setSubj(rs.getString("subject"));// 设置学科。
//				us.setNum(rs.getInt("num"));// 设置分数。
//			
//				list_user.add(us);// 装入容器。
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
	 * 查询用户
	 * @param obj 封存的对象。
	 * @param sql sql语句。
	 * @return 装载所有用户的集合
	 */
	public abstract List search(Object obj,String sql);
	
	/**
	 * 删除
	 * @param sql sql语句。
	 * @return 被删除的几行。
	 */
	public abstract int delect(String sql);
	
	/**
	 * 添加
	 * @param sql sql语句。
	 * @return 添加了几行？
	 */
	public abstract int add(String sql);
	
	/**
	 * 修改
	 * @param sql sql语句。
	 * @return 修改了几行？
	 */
	public abstract int update(String sql);
	/**
	 * 功能:关闭数据库的连接
	 */
	public void close() { // 释放资源
		try { // 捕捉异常
			try {
				if (rs != null) { // 当ResultSet对象的实例rs不为空时
					rs.close(); // 关闭ResultSet对象
				}
			} finally {
				try {
					if (stat != null) { // 当Statement对象的实例stmt不为空时
						stat.close(); // 关闭Statement对象
					}
				} finally {
					if (con != null) { // 当Connection对象的实例conn不为空时
						con.close(); // 关闭Connection对象
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err); // 输出异常信息
		}
	}
}
