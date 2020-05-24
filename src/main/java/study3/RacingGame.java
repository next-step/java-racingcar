package study3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

	Car car = new Car();
	List<Car> carList = new ArrayList<>();
	RandomGenerator rg = new RandomGenerator();
		
	public RacingGame(int carNum, int carTrial) { // 시작 전 유효성 체크 // 생성자
		ValidationCheck vc = new ValidationCheck();
		vc.carNumberCheck(carNum);
		vc.moveCountCheck(carTrial);
	}	

	// 입력받은 만큼 자동차 생성
	public List carParkinglot(int numCar) {
		for (int i = 0; i < numCar; i++) {
			carList.add(new Car());
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