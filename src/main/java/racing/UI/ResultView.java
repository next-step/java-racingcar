package racing.ui;

import racing.object.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
	
	private static final String DELIMITER = ", ";

	public void printTitle() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public void print(List<Car> carList) {
		for (Car unit : carList) {
			System.out.println(unit.getName() + " : " + printUnit(unit.getPosition()));
		}
		System.out.println();
	}
	
	private String printUnit(int moves) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < moves; ++i) {
			result.append("-");
		}
		return result.toString();
	}
	
	public void printWinner(List<Car> winners) {
		if ( winners == null || winners.isEmpty() ) {
			System.out.println("최종 우승자가 없습니다.");
			return;
		}
		System.out.println(serializeWinner(winners) + "가 최종 우승했습니다.");
	}
	
	private String serializeWinner(List<Car> winners) {
		return winners.stream().map(Car::getName).collect(Collectors.joining(DELIMITER));
	}
}
