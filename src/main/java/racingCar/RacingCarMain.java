package racingCar;

import java.util.Scanner;

public class RacingCarMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputString = in.nextLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int trial = Integer.parseInt(in.nextLine());

        RacingCar racingCar = new RacingCar(inputString);
        racingCar.setTrial(trial);
        racingCar.run();
        racingCar.showWinner();
    }
}
