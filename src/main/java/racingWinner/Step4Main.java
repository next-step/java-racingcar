package racingWinner;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Step4Main {
	
	public static void main(String[] args) {
		System.out.println("input racing car(name is seperate(,)).");
		Scanner scanner = new Scanner(System.in);
		String carsName = scanner.nextLine();
		String[] carsNameArray = carsName.split(",");
		List<Car> cars = RacingGame.makeCars(carsNameArray);
		System.out.println("what do you need to try number of races?");
		int reps = scanner.nextInt();
		RacingGame.racing(cars, reps);
		RacingGame.getWinner2(cars);
		
	}
}




	