package step5.controller;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import step5.domain.Car;
import step5.domain.CarFactory;
import step5.domain.RacingGame;
import step5.util.StringUtil;
import step5.view.PrintRacingGame;

public class Step5Main {
	
	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		Scanner scanner = new Scanner(System.in);
		String carsName = scanner.nextLine();
		CarFactory carFactory = new CarFactory(carsName);
		List<Car> carList = carFactory.getCars();
		
		System.out.println("시도할 회수는 몇회인가요?");
		int reps = scanner.nextInt();
		Random random = new Random();
		RacingGame racingGame = new RacingGame(carList);
		racingGame.racing(reps, random);
		PrintRacingGame.printWinner(racingGame.getWinner());
		
		
	}
}
