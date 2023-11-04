import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Car> cars = new ArrayList<>();

		System.out.println("자동차 대수는 몇 대 인가요?");
		int carsNumber = scanner.nextInt();
		for(int i=0; i<carsNumber; i++) {
			Car car = new Car();
			cars.add(car);
		}

		System.out.println("시도할 회수는 몇 회 인가요?");
		int tryingTimes = scanner.nextInt();

		System.out.println("실행 결과");
		for(int i=0; i<tryingTimes; i++) {
			for(Car car : cars) {
				car.tryMoving(new RandomRange(0, 9));
				car.printMovingResult();
			}
			System.out.println("");
		}
	}
}
