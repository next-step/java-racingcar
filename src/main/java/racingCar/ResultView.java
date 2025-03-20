package racingCar;

public class ResultView {
    void printResultTitle() {
        System.out.println("실행 결과");
    }

    void printPlay(RacingCar[] cars) {
        for (RacingCar car : cars) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
