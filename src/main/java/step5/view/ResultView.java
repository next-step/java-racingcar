package step5.view;

import step5.domain.RacingCar;
import step5.domain.RacingCars;

public class ResultView {

    public void printResultTitle() {
        System.out.print("\n실행 결과\n");
    }

    public void printRacingCars(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.list()) printRacingCar(racingCar);
        System.out.println();
    }

    public void printRacingCar(RacingCar racingCar) {
        System.out.printf("%s : ", racingCar.name());
        printRacingCarProgress(racingCar.position());
    }

    public void printRacingCarProgress(int position) {
        for (int i = 0; i < position; i++) System.out.print("-");
        System.out.println();
    }

    public void printWinner(RacingCars racingCars) {
        String winners = String.join(", ", racingCars.winners());
        System.out.printf("%s가 최종 우승했습니다.", winners);
    }

}
