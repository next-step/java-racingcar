package step5.view.input;

public interface InputChannel {

	static InputChannel createSystemIn() {
		return new SystemIn();
	}

	int getIntValue();

	String getStringValue();
}
