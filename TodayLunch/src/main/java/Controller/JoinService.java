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

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[jJoinService}");
		
		//1. post방식 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//2. 데이터 가져오기
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		String nickname=request.getParameter("nickname");
		String dong=request.getParameter("dong");
		
		MemberDTO dto=new MemberDTO(email, pw, nickname, dong);
//		
//		
		System.out.println("email:"+email);
		System.out.println("pw:"+pw);
		System.out.println("tel:"+nickname);
		System.out.println("address:"+dong);
		
	
		
		//3. 디비에 값 넣기
		MemberDAO dao=new MemberDAO();
		int cnt=dao.join(dto);
	
		//4.실행 결과에 따라서 다른페이지 출력하기
		
		if(cnt>0) {
			System.out.println("로그인 성공 ");
			
			//세션으로 회원가입 성공시 email값 유지시키기
			response.sendRedirect("join_success.jsp");
			HttpSession session=request.getSession();
			
			session.setAttribute("email",dto.getEmail());
			
		}else {
			System.out.println("회원가임 실패");
			response.sendRedirect("MainPage.jsp");
		}
		
	}

}
