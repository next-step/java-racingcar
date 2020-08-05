package racingEasy;

import java.util.Random;
import java.util.Scanner;

public class RacingEasy {
	public static void main(String[] args) {
		System.out.println("자동차 대수는 몇 대 인가요?");
		Scanner scanner = new Scanner(System.in);
		int carQuantity = scanner.nextInt();
		int cars[] = new int[carQuantity];
		System.out.println("시도할 회수는 몇 회 인가요?");
		int reps = scanner.nextInt();
		
		racing(cars, reps);
		
	}
	
	public static void racing(int[] cars, int reps) {
		for(int i = 1; i <= reps; i++) {
			cars = runOrStopWithRandom(cars);
			System.out.println(i + "번째");
			printCars(cars);
			System.out.println();
			System.out.println();
		}
	}
	
	//전진하는 조건은 값이 4이상일 경우이다.
	public static boolean runOrStopCondition(int num) {
		if(4 <= num && num <= 9) {
			return true;
		}
		return false;
	}
	
	//자동차는 조건에 따라 전진 또는 멈출 수 있다.
	public static int runOrStop(int condition, int car) {
		if(runOrStopCondition(condition)) {
			return ++car;
		}
		return car;
	}
	
	// 0에서 9 사이에서 random 값을 구한 후 조건에 따라 전진
	public static int[] runOrStopWithRandom(int[] cars) {
		Random random = new Random();
		for(int i = 0; i < cars.length; i++) {
			 cars[i] = runOrStop(random.nextInt(10), cars[i]);
		}
		return cars;
	}
	
	//자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
	public static void printCars(int[] cars) {
		for(int i = 0; i < cars.length; i++) {
			printCar(cars[i]);
			System.out.println();
		}
	}
	
	public static void printCar(int car) {
		for(int i = 0; i < car; i++) {
			System.out.print("-");
		}
	}
	
}
