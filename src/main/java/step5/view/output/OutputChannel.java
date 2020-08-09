package step5.view.output;

public interface OutputChannel {

	static OutputChannel createSystemOut() {
		return new SystemOut();
	}

	void printLine(String message);
}
