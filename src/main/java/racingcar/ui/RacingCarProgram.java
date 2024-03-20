package racingcar.ui;

import racingcar.domain.RacingCars;

import java.util.Scanner;

public class RacingCarProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameLine = scanner.nextLine();


        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        RacingCarGame carGame = new RacingCarGame(new RacingCars(nameLine), tryCount);
        carGame.playRacingGame();
        carGame.showRacingResult();
        carGame.showWinner();

    }
}
