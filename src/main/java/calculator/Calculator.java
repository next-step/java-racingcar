package calculator;

public class Calculator {

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

		if ("+".equals(this.sign)) {
			plus();
		}

		if ("-".equals(this.sign)) {
			minus();
		}

		if ("*".equals(this.sign)) {
			multi();
		}

		if ("/".equals(this.sign)) {
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
