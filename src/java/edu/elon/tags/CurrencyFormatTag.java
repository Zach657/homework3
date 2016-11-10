/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.tags;

import java.io.IOException;
import javax.servlet.jsp.tagext.*;

import java.text.DecimalFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author jameszach
 */
public class CurrencyFormatTag extends TagSupport{
  //Allows a number to be passed to the tag
  private String number;
  
  //Specifies the desired decimal format
  private DecimalFormat df;

  public void setNumber(double input){
    df = new DecimalFormat("#.00");
    df.setGroupingUsed(true);
    df.setGroupingSize(3);
    System.out.println(input);
    this.number = "$" + df.format(input);
  }
  
  @Override
  public int doStartTag() throws JspException {
    try {
      JspWriter out = pageContext.getOut();
      out.print(number);
    }
    catch(IOException e){
      System.out.println("IOE");
    }
    return SKIP_BODY;
  }
}
