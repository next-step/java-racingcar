package racingWinner;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class RacingWinner {
	
	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		Scanner scanner = new Scanner(System.in);
		String carsName = scanner.nextLine();
		
		String[] carsNameArray = carsName.split(",");
		if(!MakeCar.makeCarsCondition(carsNameArray)) {
			System.out.println("경주할 자동차 이름은 5자를 초과할 수 업습니디.");
			return;
		}
		
		List<Car> cars = MakeCar.makeCars(carsNameArray);
		System.out.println(cars.size());
		System.out.println("시도할 회수는 몇 회 인가요?");
		int reps = scanner.nextInt();
		RunOrStop.racing(cars, reps);
		RunOrStop.getWinner(cars);
		
	}
	
}




	