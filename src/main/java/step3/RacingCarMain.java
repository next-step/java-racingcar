package step3;

import static step3.ResultView.printRaceStep;

public class RacingCarMain {
    public static void main(String[] args) {
        int car = step3_bak.InputView.input("자동차 대수는 몇개인가요?");
        int count = InputView.input("시도할 회수는 몇 회 인가요?");

        String[][] races = new String[car][count];

        RacingCar rc = new RacingCar();
        rc.racingCar(races);
        printRaceStep(races);
    }






    //ResultView.printRaceStep(races);

}
