package racing.view;

public class ResultView {

	StringBuilder stringBuilder = new StringBuilder();

	private static final String FORWARD_MARKER = "-";

	public void print(String carName, int forwardResult) {
		stringBuilder.setLength(0);
		stringBuilder.append(carName).append(" : ");
		for (int i = 0; i < forwardResult; i++) {
			stringBuilder.append(FORWARD_MARKER);
		}
		System.out.println(stringBuilder.toString());
	}
}
