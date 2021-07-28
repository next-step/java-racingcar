package step3;

public class Main {
	public static void main(String[] args) {
		int[] answers = new InputView().answers();
		new Racing().play(answers);
	}
}