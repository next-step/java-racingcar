package racingGameMain;

import java.util.Scanner;

import racingGameMain.view.InputView;

public class RacingGameMain {
	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		int countOfCars = InputView.inputCountOfCars(sc);
		int countOfGames = Integer.parseInt(sc.nextLine());

		// Output
		System.out.println("실행 결과");
	}
}
