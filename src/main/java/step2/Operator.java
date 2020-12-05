package step2;

public class Operator {

	private int sum;

	public Operator(int sum) {
		this.sum = sum;
	}

	public Operator plus(int num) {
		sum += num;
		return this;
	}

	public Operator minus(int num) {
		sum -= num;
		return this;
	}

	public Operator multiply(int num) {
		sum *= num;
		return this;
	}

	public Operator divide(int num) {
		sum /= num;
		return this;
	}

	public Operator operate(String operator, int number) {
		switch (operator) {
			case "+":
				return plus(number);
			case "-":
				return minus(number);
			case "*":
				return multiply(number);
			case "/":
				return divide(number);
		}
		return this;
	}

	public int getSum() {
		return sum;
	}
}
