package racingcar.view;

public abstract class InputView<T> {
	String text;

	public InputView(String text) {
		this.text = text;
	}

	public abstract T getInput();

	protected void printText() {
		System.out.println(this.text);
	}
}
