<%-- 
    Created on : Oct 21, 2016, 12:38:03 AM
    Author     : James Greenwell, Casey Hayes
--%>
    <%@include file="includes/header.jsp" %>
    <header>
      <h1>Future Value Calculator</h1>
    </header>
    <form action="calculate" method="post">
      <label for="investAmount">Investment Amount</label>
      <span><br></span>
      <input type="text" name="investAmount" id="investAmount" autofocus 
             required title="Please enter a numeric value" 
             pattern="^[1-9][0-9]*([.]{1}[0-9]*)?$">
      <br>
      <label for="interestRate">Yearly Interest Rate</label>
      <span><br></span>
      <input type="text" name="interestRate" id="interestRate" required 
             title="Please enter a numeric value" 
             pattern="^[1-9][0-9]*([.]{1}[0-9]*)?$">
      <br>
      <label for="numYears">Number of Years</label>
      <span><br></span>
      <input type="text" name="numYears" id="numYears" required 
             title="Please enter a numeric value" 
             placeholder="Integer number of years" pattern="^[1-9]{1}[0-9]*$">
      <br>
      <label for="calculate"></label>
      <input type="submit" name="action" id="calculate" value="Calculate">
    </form>
    <%@include file="includes/footer.jsp" %>   
