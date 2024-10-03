package step3;

public class ResultView {
	public void printResult(Car[] cars, int moveCount) {
		System.out.println("실행 결과");
		for (int i = 0; i < moveCount; i++) {
			for (Car car : cars) {
				int printDash = car.getPositionAtMove(i);
				for (int j = 0; j < printDash; j++) {
					System.out.print("-");
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}
}
