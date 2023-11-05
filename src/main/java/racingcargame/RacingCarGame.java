package racingcargame;

import java.util.Objects;
import java.util.Random;

import static racingcargame.InputView.carNumber;
import static racingcargame.InputView.playCount;
import static racingcargame.OutputView.racingOutput;

public class RacingCarGame {

    private static Random random = new Random();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();
        playRacingCar();
    }

    public static void playRacingCar() {
        OutputView outputView = new OutputView();
        racingOutput = new String[carNumber];

        System.out.println("실행 결과");
        for (int i = 0; i < playCount; i++) {
            for (int j = 0; j < carNumber; j++) {
                int randomNumber = random.nextInt(10);
                if (isPossibleToMove(randomNumber)) {
                    racingOutput[j] = moveForward(racingOutput[j]);
                }
            }

            outputView.output();
        }
    }

    public static boolean isPossibleToMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public static String moveForward(String racingCarStatus) {
        return Objects.isNull(racingCarStatus) ? "-" : racingCarStatus + "-";
    }
}
