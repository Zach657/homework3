<%-- 
    Created on : Oct 21, 2016, 1:08:20 AM
    Author     : James Greenwell, Casey Hayes
--%>
    <%@taglib prefix="elon" uri="/WEB-INF/tag.tld"%>
    <%@include file="includes/header.jsp" %>
    <header>
      <h1>Future Value Calculator</h1>
    </header>
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
      </table>
      <table id="yoyt">
        <thead>
          <tr>
            <th>Year</th>
            <th>Value</th>
          </tr> 
        </thead>
        <c:forEach var="i" begin="1" end="${investCalc.years}">
          <tr>
            <th>${i}</th>
            <td><elon:currencyFormat number="${investCalc.yoyVals[i-1]}"></elon:currencyFormat></td>
          </tr>
        </c:forEach>
      </table>
      <div>
        <a href="<c:url value='/calculate'/>">
          Return to Calculator
        </a> 
      </div>
    <%@include file="includes/footer.jsp" %>
