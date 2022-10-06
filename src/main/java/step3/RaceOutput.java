package step3;

public class RaceOutput {

    private static final String INDICATOR = "-";

    public RaceOutput() {
        System.out.println("실행 결과");
    }

    public void print(Cars cars) {
        for (Car car : cars) {
            System.out.println(INDICATOR.repeat(car.location()));
        }
        System.out.println();
    }
}
