package step4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

	private static final String DELIMITER = ", ";

	private final List<String> winners;

    public Winners() {
        winners = new ArrayList<>();
    }

    public int getWinnerStandard(Cars cars){
		int maxMoveCnt = 0;
		for(Car car : cars.getCars()){
			maxMoveCnt = Math.max(maxMoveCnt, car.getMoveCnt());
		}

		return maxMoveCnt;
	}

	public void checkWinners(Cars cars, int maxMoveCnt) {
		for(Car car : cars.getCars()){
			isWinner(maxMoveCnt, car);
		}
	}

	private void isWinner(int maxMoveCnt, Car car) {
		if(maxMoveCnt == car.getMoveCnt()) {
			winners.add(car.getName());
		}
	}

	public String getWinners(){
		return winners.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(DELIMITER));
	}
}
