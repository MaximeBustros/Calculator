package enterprise.calculator_stateless_bean;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * the session bean.
 */
@Stateless(name = "myCalculator")
public class CalculatorStatelessBean implements CalculatorStateless {
	/**
	 * the implementation of the method of the API.
	 * 
	 * @return the message.
	 */
	public double add(double n1, double n2) { return n1 + n2; }
	public double sub(double n1, double n2) { return n1 - n2; }
	public double mul(double n1, double n2) { return n1 * n2; }
	public double div(double n1, double n2) { return n1 / n2; }
	public double square(double n1) 		{ return n1 * n1; }
	@Asynchronous
	public Future<Double> addAsync(double n1, double n2) { return new AsyncResult<Double>(n1 + n2); }
	@Asynchronous
	public Future<Double> subAsync(double n1, double n2) { return new AsyncResult<Double>(n1 - n2); }
	@Asynchronous
	public Future<Double> mulAsync(double n1, double n2) { return new AsyncResult<Double>(n1 * n2); }
	@Asynchronous
	public Future<Double> divAsync(double n1, double n2) { return new AsyncResult<Double>(n1 / n2); }
	@Asynchronous
	public Future<Double> squareAsync(double n1) 		 { return new AsyncResult<Double>(n1 * n1); }
	
}
