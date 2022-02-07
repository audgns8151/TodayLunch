package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ChoiceDAO;
import model.ChoiceDTO;
public class ChoiceService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ChoiceService");
		
		request.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("Value");
		
		System.out.println("type:"+type);
		
		
		
		ChoiceDAO dao = new ChoiceDAO();
		ArrayList<ChoiceDTO> choice = dao.showMessage(type);
		
		// 랜덤값 출력
		Random rd = new Random();
		int rd_num = rd.nextInt(choice.size());
		System.out.println(choice.get(rd_num).getExplain());
		request.setAttribute("food", choice.get(rd_num));
		
		//수업시간에 forward 배우신적 있나요 아뇨.. 음 response를 다음 페이지로 보내는 방법이 크게 두가지가 있는데
		// 하나가 여러분 자주쓰는 sendredirect구요 다른 하나가 요 forward라는 애에요 넵
		// 차이점이 이것저것 있는데 가장 큰 차이점은 이 redirect는 request, response객체가 초기화되고
		// forward는 초기화 되지 않기때문에request.setAttribute 한 내용을 저기서 불러다 쓸수 있게 됩니다.
 		RequestDispatcher rq = request.getRequestDispatcher("ChoiceFinal.jsp");
	    rq.forward(request, response);       
		
	}

}
