package study4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

	Car car = new Car();
	List<Car> carList = new ArrayList<>();
	RandomGenerator rg = new RandomGenerator();

	public RacingGame(String carName, int carTrial) { // 시작 전 유효성 체크 // 생성자
		ValidationCheck vc = new ValidationCheck();
		vc.carNameCheck(carName); // 자동차이름 check
		vc.moveCountCheck(carTrial);
	}

	public List splitCarName(String carName) {
		String[] names = carName.split(",");

		for (int i = 0; i < names.length; i++) {
			carList.add(new Car());
			carList.get(i).setCarName(names[i]); // 이름저장
		}

		return carList;
	}

	// 자동차 이동
	public List racingcarMove(List<Car> carList) {
		for (Car car : carList) {
			car.move(rg.randomGenerate());
		}
		return carList;
	}

}