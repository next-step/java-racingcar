package racing;

public class ResultView {

    public void viewMessage() {
        System.out.println("실행 결과");
    }

    public void viewRoundResult(final RacingCars racingCars) {
        for (final Car car : racingCars.getCars()) {
            System.out.println(car.getDisplacement());
        }

        System.out.println();
    }
}
