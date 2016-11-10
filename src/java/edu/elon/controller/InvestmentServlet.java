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

/** 
 * Copyright (C) 2016 - James Greenwell
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
    
    //fetch current year for copyright
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    request.setAttribute("currentYear", currentYear);
    
    String action = request.getParameter("action");
    //sets the default action if none is given
    if(action == null){
      action = "Invest";
    }
    System.out.println(action);
    if(action.equals("Calculate")){
      Double investAmount = Double.parseDouble(
              request.getParameter("investAmount"));
      Double interestRate = Double.parseDouble(
              request.getParameter("interestRate"));
      int numYears = Integer.parseInt(request.getParameter("numYears"));
      System.out.println("Investment Amount: " + investAmount);
      System.out.println("Interest Rate: " + interestRate);
      System.out.println("Years: " + numYears);
      InvestmentCalculator invCalc = new InvestmentCalculator(investAmount,
              interestRate,numYears);
      invCalc.calcFutureVal();
      request.setAttribute("investCalc",invCalc);
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
