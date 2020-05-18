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
		System.out.println("utf-8 인코딩............");
		context = fConfig.getServletContext();

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		//한글 인코딩 설정
		request.setCharacterEncoding("utf-8");
		//웹 어플리케이션 컨텍스트의 이름을 가져옴
		String context = ((HttpServletRequest)request).getContextPath();
		//웹 브라우저에서 요청한 요청 url을 가져옴
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		//요청 url의 실제 경로를 가져옴
		String realPath = request.getRealPath( pathinfo);
		
		String mesg = " Context 정보: " + context + "\n URI 정보: " + pathinfo + "\n 물리적 경로: " + realPath;
		System.out.println(mesg);
		//요청 필터에서 요청 처리 전의 시각을 구함
		long begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		//응답 필터에서 요청 처리 후의 시간을 구함
		long end = System.currentTimeMillis();
		System.out.println("작업시간:" +(end-begin)+"ms");
	}
}
