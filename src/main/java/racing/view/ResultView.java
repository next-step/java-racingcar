package racing.view;

import racing.util.Constants;

public class ResultView {

	StringBuilder stringBuilder = new StringBuilder();

	public void print(String carName, int forwardResult) {
		stringBuilder.setLength(0);
		stringBuilder.append(carName).append(Constants.CAR_NAME_MARKER);
		for (int i = 0; i < forwardResult; i++) {
			stringBuilder.append(Constants.FORWARD_MARKER);
		}
		System.out.println(stringBuilder.toString());
	}
}
