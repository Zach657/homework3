package edu.elon.controller;

import edu.elon.model.InvestmentCalculator;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
 * Copyright (C) 2016 - James Greenwell, Casey Hayes
 * Elon University
 */
@WebServlet(name = "InvestmentServlet", urlPatterns = {"/calculate"})
public class InvestmentServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, 
          HttpServletResponse response)
          throws ServletException, IOException {
    
    String action = request.getParameter("action");
    //sets the default action if none is given
    if(action == null){
      action = "Invest";
    }
    if(action.equals("Calculate")){
      Double investAmount = Double.parseDouble(
              request.getParameter("investAmount"));
      Double interestRate = Double.parseDouble(
              request.getParameter("interestRate"));
      int numYears = Integer.parseInt(request.getParameter("numYears"));
      InvestmentCalculator invCalc = new InvestmentCalculator(investAmount,
              interestRate,numYears);
      
      HttpSession session = request.getSession();
      session.setAttribute("investCalc",invCalc);
      
      invCalc.calcFutureVal();
      
      //redirects user to result.jsp
      String url = "/result.jsp";
      getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    else{
      //redirects user to invest.jsp
      String url = "/invest.jsp";
      getServletContext().getRequestDispatcher(url).forward(request, response);
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. 
  // Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, 
          HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }
}
