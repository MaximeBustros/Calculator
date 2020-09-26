package enterprise.calculator_stateless_client;

import java.util.concurrent.Future;

import javax.naming.Context;
import javax.naming.InitialContext;
import enterprise.calculator_stateless_bean.CalculatorStateless;

/**
 * The client application.
 */
public final class CalculatorStatelessJavaClient {
	/**
	 * private client to avoid instantiation.
	 */
	private CalculatorStatelessJavaClient() {
	}

	/**
	 * The main of the client.
	 * 
	 * @param args
	 *            there is no command line arguments.
	 */
	public static void main(String args[]) throws Exception {
		Context myContext = new InitialContext();
		CalculatorStateless myCalc = (CalculatorStateless) myContext.lookup("enterprise.calculator_stateless_bean.CalculatorStateless");
		Future<Double> asyncRes;
		double result;
		
		// Synchronous
		result = myCalc.add(1, 2);
		System.out.println("1 + 2 = "+ result);
		
		result = myCalc.sub(4, 1);
		System.out.println("4 - 1 = " + result);
		
		result = myCalc.mul(2,4);
		System.out.println("2 * 4 = "+ result);
		
		result = myCalc.div(10, 2);
		System.out.println("10 / 2 = " + result);
		
		result = myCalc.square(2);
		System.out.println("2 squared = " + result);
		
		// Asynchronous
		Future<Double> asyncAddRes = myCalc.addAsync(2, 4);
		Future<Double> asyncSubRes = myCalc.subAsync(2, 4);
		Future<Double> asyncMulRes = myCalc.mulAsync(2, 4);
		Future<Double> asyncDivRes = myCalc.divAsync(2, 4);
		Future<Double> asyncSquaredRes = myCalc.squareAsync(2);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {e.printStackTrace();} 
		// Use get to wait for results synchronously
		System.out.println("Async 2 + 4 = " + asyncAddRes.get());
		System.out.println("Async 2 - 4 = " + asyncSubRes.get());
		System.out.println("Async 2 * 4 = " + asyncMulRes.get());
		System.out.println("Async 2 / 4 = " + asyncDivRes.get());
		System.out.println("Async 2 squared = " + asyncSquaredRes.get());
	}
}
