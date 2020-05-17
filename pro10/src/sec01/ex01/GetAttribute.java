package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		HttpSession sess = request.getSession();
		
		//������ ���ε��� request ��ü�� /get���� ��û�Ͽ� ������ request ��ä�� �ٸ��Ƿ� null�� ���
		//���� �ٸ� ���������� /get���� ��û �� Context ��ü�� ������ �������� �������� �޶� ���ε� �� �� ���� 
		String ctxMesg = "context�� ���ε� �˴ϴ�.";
		String sesMesg = "session�� ���ε� �˴ϴ�.";
		String reqMesg = "request�� ���ε� �˴ϴ�."; 
		
		out.print("context��: " + ctxMesg + "<br>");
		out.print("session��: " + sesMesg + "<br>");
		out.print("request��: " + reqMesg + "<br>");
	}
}
