package step1;

import java.util.Scanner;

public class RacingCarMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("input CarName!!(carName은 쉼표(,)로 구분).");
        String inputString = in.nextLine();

        System.out.println("시도할 Count는 몇 회인가요?");
        int trial = Integer.parseInt(in.nextLine());

        RacingCar racingCar = new RacingCar(inputString);
        racingCar.setTrial(trial);
        racingCar.run();
        racingCar.showWinner();
    }
}
