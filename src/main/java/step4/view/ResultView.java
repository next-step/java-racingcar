package step4.view;

import java.util.List;

import step4.domain.car.Car;
import step4.domain.car.CarList;

public final class ResultView {
	public static void printRacingHistory(CarList carList) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("실행 결과\n");
		for (int i = 0; i < carList.getMovedCount(); i++) {
			printCarPositionsAtMoveTime(carList, i, stringBuilder);
		}
		printWinner(carList, stringBuilder);
		System.out.println(stringBuilder);
	}

	private static void printCarPositionsAtMoveTime(CarList carList, int moveCount, StringBuilder stringBuilder) {
		for (Car car : carList.getList()) {
			stringBuilder.append(car.getName()).append(" : ");
			printCarPositionAtMoveTime(car.getCarPositionHistory().get(moveCount), stringBuilder);
		}
		stringBuilder.append("\n");
	}

	private static void printCarPositionAtMoveTime(Integer carPosition, StringBuilder stringBuilder) {
		for (int i = 0; i < carPosition; i++) {
			stringBuilder.append("-");
		}
		stringBuilder.append("\n");
	}

	private static void printWinner(CarList carList, StringBuilder stringBuilder) {
		List<Car> winners = carList.getWinner();
		for (int i = 0; i < winners.size(); i++) {
			if (i > 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(winners.get(i).getName());
		}
		stringBuilder.append("가 최종 우승했습니다.");
	}
}
