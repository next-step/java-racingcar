package racingWinner;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Step4Main {
	
	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		Scanner scanner = new Scanner(System.in);
		String carsName = scanner.nextLine();
		String[] carsNameArray = carsName.split(",");
		List<Car> cars = RacingGame.makeCars(carsNameArray);
		System.out.println("시도할 회수는 몇회인가요?");
		int reps = scanner.nextInt();
		RacingGame.racing(cars, reps);
		RacingGame.getWinner2(cars);
	}
}




	