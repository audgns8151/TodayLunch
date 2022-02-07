package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ChoiceDTO;

public class ChoiceService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ChoiceService");
		
		request.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("type");
		
		System.out.println("type:"+type);
		
		ArrayList<ChoiceDTO> choice = new ArrayList<ChoiceDTO>();
		
		
	}

}
