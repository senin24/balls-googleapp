package com.github.senin24.balls;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.senin24.balls.app.App;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  
	  response.setIntHeader("Refresh", 1);
      
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().print("Hello 'BallsApp' in GoogleCloud (App Engine)!\r\n");
    response.getWriter().print("'5-3' means: ball number 5, pause - 3 sec \r\n\r\n");
    
    App app = App.INSTANCE;
    try {
		app.start();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    response.getWriter().print(app.print());
    

  }
  
  
  
  
}