package racing.view;

public class ResultView {

	StringBuilder stringBuilder = new StringBuilder();

	public void print(String carName, int forwardRecult) {
		stringBuilder.setLength(0);
		stringBuilder.append(carName).append(" : ");
		for (int i = 0; i < forwardRecult; i++) {
			stringBuilder.append("-");
		}
		System.out.println(stringBuilder.toString());
	}
}
