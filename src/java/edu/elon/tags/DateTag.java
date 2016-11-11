package edu.elon.tags;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/** 
 * Copyright (C) 2016 - James Greenwell, Casey Hayes
 * Elon University
 */

//making this a generic date tag to be open to extension of other date values
public class DateTag extends TagSupport {

 @Override
  public int doStartTag() throws JspException {
    
    //find current year from calendar
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);

    try {
      JspWriter out = pageContext.getOut();
      out.print(currentYear);
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
    return SKIP_BODY;
  }
}
