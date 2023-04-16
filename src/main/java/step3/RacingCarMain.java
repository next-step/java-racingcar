package step3;

import static step3.InputView.input;
import static step3.ResultView.printRaceStep;

public class RacingCarMain {
    public static void main(String[] args) {
        int car = input("자동차 대수는 몇 대 인가요?");
        int count = input("시도할 회수는 몇 회 인가요?");

        String[][] races = new String[car][count];

        RacingCar rc = new RacingCar();
        rc.racingCar(races);

        printRaceStep(races);
    }

}
