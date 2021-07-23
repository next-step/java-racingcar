package step2;

public class Main {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int result = calculator.execute("1 + 2 * 3 / 4");
		System.out.println(result);
	}
}
