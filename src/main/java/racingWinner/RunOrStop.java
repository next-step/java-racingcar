package racingWinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunOrStop {
	private final static int RUN = 4;
	
	//랜덤 클래스를 한번만 사용하게 변경
	public static void racing(List<Car> cars, int reps) {
		Random random = new Random();
		for(int i = 1; i <= reps; i++) {
			cars =  runOrStopWithRandom(cars, random);
			System.out.println(i + "번째");
			printCars(cars);
			System.out.println();
			System.out.println();
		}
	}
	
	//전진하는 조건은 값이 4이상일 경우이다.
	public static boolean runOrStopCondition(int num) {
		if(RUN <= num) {
			return true;
		}
		return false;
	}
	
	//자동차는 조건에 따라 전진 또는 멈출 수 있다.
	//Car 클래스로 변경
	public static Car runOrStop(int condition, Car car) {
		if(runOrStopCondition(condition)) {
			car.setLocation(car.getLocation() + 1);
		}
		return car;
	}
	
	// 0에서 9 사이에서 random 값을 구한 후 조건에 따라 전진
	//Car 클래스로 변경
	public static List<Car> runOrStopWithRandom(List<Car> cars, Random random) {
		for(int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			car = runOrStop(random.nextInt(10), cars.get(i));
			cars.set(i, car);
		}
		return cars;
	}
	
	//자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
	//Car 클래스로 변경
	public static void printCars(List<Car> cars) {
		for(int i = 0; i < cars.size(); i++) {
			printCar(cars.get(i));
			System.out.println();
		}
	}
	
	//Car 클래스로 변경
	public static void printCar(Car car) {
		System.out.print(car.getCarName() + " : ");
		for(int i = 0; i < car.getLocation(); i++) {
			System.out.print("-");
		}
	}

	//max와 차의 최대 이동거리 비교
	public static int getMaxLocation(int max, Car car) {
		if(max < car.getLocation()) {
			max = car.getLocation();
		}
		return max;
	}
	
	//차 최대 이동 거리 구하기
	public static int getMaxLocationWithList(List<Car> cars) {
		int max = 0;
		for(int i = 0; i < cars.size(); i++) {
			max = getMaxLocation(max, cars.get(i));
		}
		return max;
	}
	
	//우승한 차 클래스 구하기
	public static List<Car> getWinnerName(int max, Car car, List<Car> winner) {
		if(max == car.getLocation()) {
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
		printWinner(winner);
	}
	
	public static void printWinner(List<Car> winner) {
		for(int i = 0; i < winner.size(); i++) {
			System.out.print(winner.get(i).getCarName() + seperator(winner.size(), i + 1));
		}
		System.out.print("가 최종 우승했습니다.");
	}
	
	public static String seperator(int size, int compare) {
		if(size > compare) {
			return ", ";
		}
		return "";
	}
	
	
	
}
