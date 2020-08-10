package racingWinner;

import java.util.ArrayList;
import java.util.List;

public class GetWinners {
	
	//최대값과 카 객체의 위치값 비교
	public static int getMaxLocation(int max, Car car) {
		if(max < car.getLocation()) {
			max = car.getLocation();
		}
		return max;
	}
	
	//경주한 차들의 최대값 얻기
	public static int getMaxLocationWithList(List<Car> cars) {
		int max = 0;
		for(int i = 0; i < cars.size(); i++) {
			max = getMaxLocation(max, cars.get(i));
		}
		return max;
	}
	
	//구한 max과 같은 카 객체가 있으면 우승자 리스트에 더해줌
	public static List<Car> getWinnerName(int max, Car car, List<Car> winner) {
		if(car.winner(max) != null) {
			winner.add(car);
		}
		return winner;
	}
	
	public static void getWinner(List<Car> cars) {
		int max = getMaxLocationWithList(cars);
		List<Car> winner = new ArrayList<Car>();
		for(int i = 0; i < cars.size(); i++) {
			winner = getWinnerName(max, cars.get(i), winner);
		}
		PrintCar.printWinner(winner);
	}
}
