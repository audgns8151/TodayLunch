package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginService");
		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		System.out.println("email"+email);
		System.out.println("pw"+pw);
		
		//longin메소드가 있는 Dao 호출
		
		MemberDAO dao=new MemberDAO();
		
		//입력받아오 email pw,를 dto로 만들어주기 
		MemberDTO dto=new MemberDTO(email, pw);
		
		//email,pw,tel,address 4개를 받은 dto  생성
		MemberDTO info=dao.login(dto);
		
		//성공실패 다지기
		if(info!=null) {
			System.out.println("로그인 성공");
			
			response.sendRedirect("Main.jsp?check=success");
		
			HttpSession session=request.getSession();
			session.setAttribute("info", info);
		}else {
			System.out.println("로그인 실패");
			response.sendRedirect("Login.jsp?check=fail");

		}

	}

}
