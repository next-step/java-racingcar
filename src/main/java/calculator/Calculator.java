package calculator;

public class Calculator {

	public static final String OPERATOR_PLUS = "+";
	public static final String OPERATOR_MINUS = "-";
	public static final String OPERATOR_MULTI = "*";
	public static final String OPERATOR_MOD = "/";


	private int result;
	private int calculateNumber;
	private String sign;

	public Calculator(int firstNumber) {

		this.result = firstNumber;
	}

	public void calculate(String signStr, int calculateNumber) {

		this.calculateNumber = calculateNumber;
		this.sign = signStr;

		calculate();
	}

	private void calculate() {

		if (OPERATOR_PLUS.equals(this.sign)) {
			plus();
		}

		if (OPERATOR_MINUS.equals(this.sign)) {
			minus();
		}

		if (OPERATOR_MULTI.equals(this.sign)) {
			multi();
		}

		if (OPERATOR_MOD.equals(this.sign)) {
			mod();
		}
	}

	public int getResult() {

		return this.result;
	}

	private void plus() {

		this.result += this.calculateNumber;
	}

	private void minus() {

		this.result -= this.calculateNumber;
	}

	private void mod() {

		this.result /= this.calculateNumber;
	}

	private void multi() {

		this.result *= this.calculateNumber;
	}
}
