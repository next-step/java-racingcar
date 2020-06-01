package study4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {

	static List<Car> carList = new ArrayList();
	RandomGenerator rg = new RandomGenerator();

	public RacingGame(String carName, int carTrial) { // 시작 전 유효성 체크 // 생성자
		ValidationCheck vc = new ValidationCheck();
		vc.carNameCheck(carName); // 자동차이름 check
		vc.moveCountCheck(carTrial);
	}

	public static List splitCarName(String carName) {
		
		String[] names = carName.split(",");
		
		// 리팩토링
		Arrays.stream(names)
			.map(Car::new)
			.map(carList::add)
			.collect(Collectors.toList());
		
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