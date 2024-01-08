
pubic void m2(){
String s= "shadrak";

}

@WebServlet("/Cal")
public class CalculatorServlets extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		pw.println("I am from do Post method ......!");

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html"); // >>This line is will not not allow to display on the browser>>
												// "<b>The error is:- </b>" and "<b><a href='index.html'>GO Back</a>"
		PrintWriter pw = response.getWriter();
		pw.println("I am from doGet() method");
		String first = request.getParameter("first_number");
		String second = request.getParameter("second_number");
		String Choose = request.getParameter("opCode");

		double d1 = 0;
		String errorMessage = "";
		try {
			d1 = Double.parseDouble(first);
		} catch (NumberFormatException ex) {
			errorMessage += "please enter the numbers only in A";
		}

		double d2 = 0;
		try {
			d2 = Double.parseDouble(second);
		} catch (NumberFormatException ex) {
			errorMessage += "please enter the numbers only in B";

		}

		if (errorMessage.length() == 0) {
			double result = 0;

			switch (Choose) {
			case "1": {
				result = d1 + d2;
				break;
			}
			case "2": {
				result = d1 - d2;
				break;
			}
			case "3": {
				result = d1 * d2;
				break;
			}
			case "4": {
				result = d1 / d2;
				break;
			}

			}

			pw.println("<b>Result:-  " + result);
		} else {
			pw.println("<b>The error is:- </b> " + errorMessage);
			System.out.println(errorMessage);
		}
		pw.println("<b><a href='index.html'>GO Back</a>");
		pw.close();
	}

}
