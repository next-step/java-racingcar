package racingWinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrintCar {
	
	//경주 값 출력
	public static void racing(List<Car> cars, int reps) {
		Random random = new Random();
		for(int i = 1; i <= reps; i++) {
			cars =  MakeCars.runOrStopWithRandom(cars, random);
			System.out.println(i + "번째");
			printCars(cars);
			System.out.println();
			System.out.println();
		}
	}
	
	
	//카 객체 이동 횟수 출력
	public static void printCars(List<Car> cars) {
		for(int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i).printCar());
			System.out.println();
		}
	}
	
	//우승자 출력
	public static void printWinner(List<Car> winner) {
		for(int i = 0; i < winner.size(); i++) {
			System.out.print(winner.get(i).getName() + seperator(winner.size(), i + 1));
		}
		System.out.print("가 최종 우승했습니다.");
	}
	
	//구분자 출력
	public static String seperator(int size, int compare) {
		if(size > compare) {
			return ", ";
		}
		return "";
	}
}
