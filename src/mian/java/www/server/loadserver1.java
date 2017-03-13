package www.server;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import www.bean.Film;

import www.bean.User_load;
import www.dao.Load_dao;

@WebServlet("/loadserver1")
public class loadserver1 extends HttpServlet {

		private static final long serialVersionUID = 1L;

		public  void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// 设置页面的编码。
			response.setContentType("text/html;charset='utf-8'");
			// 设置响应的编码。
			response.setCharacterEncoding("utf-8");
			// 设置请求的编码。
			request.setCharacterEncoding("utf-8");
			// 创建application
			ServletContext application = request.getServletContext();
			// 获取session对象。
			HttpSession session = request.getSession();
			// 接收用户名id。
			String name = request.getParameter("name");
			System.out.println(name);
			String pwd = request.getParameter("pwd");
			System.out.println(pwd);
			Load_dao load = new Load_dao();
			ArrayList<User_load> list1= (ArrayList<User_load>) load.search("select name from user where name = '" + name + "'");
			if (list1.size() == 0) {
				response.sendRedirect("load.jsp");
			} else {
				for (int i = 0; i < list1.size(); i++) {

					if (list1.get(i).getName().equals(name)) {
						ArrayList<Film> ulist = null;
						
						ulist =(ArrayList<Film>)load.search1("select  film_id，name ，description，langauge from film");
						for (int i=0; i<ulist.size(); i++) {
							System.out.println(ulist);
						}
						
						session.setAttribute("ulist", ulist);
						
						
						response.sendRedirect("show.jsp");
						
						
						
					}
					} 
				}
			}
			
		}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		
			
		}
			
		}
	}

