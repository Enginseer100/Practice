package sec04.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


//�α��� �����ڼ� ǥ��
public class LoginImpl implements HttpSessionBindingListener {
	String user_id;
	String user_pw;
	static int total_user = 0;

	public LoginImpl() {
	}

	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
 
	//���ǿ��� ���ε� �� ������ �� ����
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("����� ����");
		++total_user;
	}
	//���ǿ��� �Ҹ� �� ������ �� ����
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("����� ���� ����");
		total_user--;
	}
}