package step4;

public class RaceOutput {

    private static final String INDICATOR = "-";

    public RaceOutput() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars) {
            System.out.println(car.name() + " : " + INDICATOR.repeat(car.location()));
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        for (Car car : cars.winners()) {
            System.out.print(car.name());
        }
        System.out.println(" (이)가 최종 우승했습니다.");
    }
}
