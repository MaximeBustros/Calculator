package enterprise.calculator_stateless_bean;

import javax.ejb.Remote;

import java.util.concurrent.Future;

/**
 * the API.
 */
@Remote
public interface CalculatorStateless {
	/**
	 * the method of the API.
	 * 
	 * @return the message "hello world".
	 */
	public double add(double n1, double n2);
	public double sub(double n1, double n2);
	public double mul(double n1, double n2);
	public double div(double n1, double n2);
	public double square(double n1);
	public Future<Double> addAsync(double n1, double n2);
	public Future<Double> subAsync(double n1, double n2);
	public Future<Double> mulAsync(double n1, double n2);
	public Future<Double> divAsync(double n1, double n2);
	public Future<Double> squareAsync(double n1);

}
