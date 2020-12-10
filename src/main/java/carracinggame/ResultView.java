package carracinggame;

public class ResultView {
	public void printResultText() {
		System.out.println("실행 결과");
	}

	public void printCarPosition(int position) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}

	public void nextLine() {
		System.out.println();
	}
}
