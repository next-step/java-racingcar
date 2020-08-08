package step3;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {
	
	public List<Car> init(int value) {
		List<Car> carList = new ArrayList<Car>();
		
		for(int i = 0 ; i < value ; i ++) {
			carList.add(new Car());
		}
		
		return carList;
	}
	
	public void run(int value, int number) {
		List<Car> cars = init(value);
		
		for(int i = 0 ; i < number; i ++) {
			cars.stream()
					.forEach(car -> car.run(getRandomNum()));
			System.out.println();
		}
	}
	
	
	public int getRandomNum() {
		Random random = new Random();		
		return random.nextInt(10);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("자동차 대수는 몇 대 인가요?");
		int value = scanner.nextInt();
		
		System.out.println("시도할 회수는 몇 회 인가요?");
		int number = scanner.nextInt();
		
		RacingCar racingCar = new RacingCar();
		
		racingCar.run(value, number);
	}
}
