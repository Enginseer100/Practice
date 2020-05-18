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
		
		//기존에 바인딩된 request 객체는 /get으로 요청하여 생성된 request 객채와 다르므로 null이 출력
		//만약 다른 브라우저에서 /get으로 요청 시 Context 객체를 제외한 나머지는 브라우저가 달라 바인딩 할 수 없음 
		String ctxMesg = "context에 바인딩 됩니다.";
		String sesMesg = "session에 바인딩 됩니다.";
		String reqMesg = "request에 바인딩 됩니다."; 
		
		out.print("context값: " + ctxMesg + "<br>");
		out.print("session값: " + sesMesg + "<br>");
		out.print("request값: " + reqMesg + "<br>");
	}
}
