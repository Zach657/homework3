<%-- 
    Created on : Oct 21, 2016, 1:08:20 AM
    Author     : James Greenwell, Casey Hayes
--%>
    <%@taglib prefix="elon" uri="/WEB-INF/tag.tld"%>
    <%@include file="includes/header.jsp" %>
    <header>
      <h1>Future Value Calculator</h1>
    </header>
    <jsp:useBean id="investCalc" scope="request" 
                 class="edu.elon.model.InvestmentCalculator"/>
      <table>
        <tr>
          <th>Investment Amount:</th>
          <td><elon:currencyFormat number="${investCalc.cash}"></elon:currencyFormat></td>
        </tr>
        <tr>
          <th>Yearly Interest Rate:</th>
          <td>${investCalc.ratePercent}</td>
        </tr>
        <tr>
          <th>Number of Years:</th>
          <td>${investCalc.years}</td>
        </tr>
        <tr>
          <th>Future Value:</th>
          <td>${futureVal}<elon:currencyFormat number="${investCalc.futureVal}"></elon:currencyFormat></td>
        </tr>
      </table>
    <%@include file="includes/footer.jsp" %>
