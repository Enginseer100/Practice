package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter implements Filter {

	ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 ���ڵ�............");
		context = fConfig.getServletContext();

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter ȣ��");
		//�ѱ� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		//�� ���ø����̼� ���ؽ�Ʈ�� �̸��� ������
		String context = ((HttpServletRequest)request).getContextPath();
		//�� ���������� ��û�� ��û url�� ������
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		//��û url�� ���� ��θ� ������
		String realPath = request.getRealPath( pathinfo);
		
		String mesg = " Context ����: " + context + "\n URI ����: " + pathinfo + "\n ������ ���: " + realPath;
		System.out.println(mesg);
		//��û ���Ϳ��� ��û ó�� ���� �ð��� ����
		long begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		//���� ���Ϳ��� ��û ó�� ���� �ð��� ����
		long end = System.currentTimeMillis();
		System.out.println("�۾��ð�:" +(end-begin)+"ms");
	}
}
