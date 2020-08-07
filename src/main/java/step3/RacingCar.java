package step3;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

	private static final int CAN_MOVE_NUM = 4;
	private static final String MOVE_MARK = "-";
	private static final Random random = new Random();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("자동차 대수는 몇 대 인가요?");
		int carCount = scanner.nextInt();

		StringBuilder[] cars = getNewCars(carCount);

		System.out.println("시도할 횟수는 몇 회 인가요?");
		int times = scanner.nextInt();

		for (int i = 0; i < times; i++) {
			moveForward(cars);
		}

	}

	public static StringBuilder[] getNewCars(int carCount) {
		StringBuilder[] cars = new StringBuilder[carCount];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new StringBuilder("");
		}
		return cars;
	}

	public static void moveForward(StringBuilder[] cars) {
		for (int i = 0; i < cars.length; i++) {
			checkCarsCanMove(cars[i]);
		}
		System.out.println();
	}

	public static void checkCarsCanMove(StringBuilder car) {
		if(canMoveForward(random.nextInt(9))) {
			car.append(MOVE_MARK);
		}
		System.out.println(car);
	}

	public static boolean canMoveForward(int randomNumber) {
		return randomNumber >= CAN_MOVE_NUM;
	}

}
