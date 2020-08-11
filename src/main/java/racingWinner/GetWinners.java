package racingWinner;

import java.util.ArrayList;
import java.util.List;

public class GetWinners {
	public static int getMaxLocation(int max, Car car) {
		if(max < car.getLocation()) {
			max = car.getLocation();
		}
		return max;
	}
	
	public static int getMaxLocationWithList(List<Car> cars) {
		int max = 0;
		for(int i = 0; i < cars.size(); i++) {
			max = getMaxLocation(max, cars.get(i));
		}
		return max;
	}
	
	//getter 를 사용하지 않고 Car 객체에 메세지를 전달하여 우승자를 구할 수 있을 것 같아요.
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
