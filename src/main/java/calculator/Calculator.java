package calculator;

public class Calculator {

	private int result;
	private int calculateNumber;
	private String sign;

	public Calculator(int firstNumber) {

		this.result = firstNumber;
	}

	public void plus() {

		this.result = this.result + this.calculateNumber;
	}

	public void minus() {

		this.result = this.result - this.calculateNumber;
	}

	public void mod() {

		this.result = this.result / this.calculateNumber;
	}

	public void multi() {

		this.result = this.result * this.calculateNumber;
	}

	public int getResult() {

		return this.result;
	}

	public void calculate() {

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

	public void calculate(String signStr, int number2) {

		calculateNumber = number2;
		sign = signStr;

		calculate();
	}
}
