<%-- 
    Created on : Oct 21, 2016, 1:08:20 AM
    Author     : James Greenwell, Casey Hayes
--%>
    <%@include file="includes/header.jsp" %>
    <header>
      <h1>Future Value Calculator</h1>
    </header>
    <jsp:useBean id="investCalc" scope="request" 
                 class="edu.elon.model.InvestmentCalculator"/>
      <table>
        <tr>
          <th>Investment Amount:</th>
          <td>&dollar;<jsp:getProperty name = "investCalc" 
                           property="formattedCash"/></td>
        </tr>
        <tr>
          <th>Yearly Interest Rate:</th>
          <td><jsp:getProperty name = "investCalc" property="ratePercent"/></td>
        </tr>
        <tr>
          <th>Number of Years:</th>
          <td><jsp:getProperty name = "investCalc" property="years"/></td>
        </tr>
        <tr>
          <th>Future Value:</th>
          <td>&dollar;<jsp:getProperty name = "investCalc" 
                           property="futureVal"/></td>
        </tr>
      </table>
    <%@include file="includes/footer.jsp" %>
