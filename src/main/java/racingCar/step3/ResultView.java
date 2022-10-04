package racingCar.step3;

public class ResultView {
    public void print(String str) {
        System.out.println(str);
    }

    public void print(RacingCar[] result) {
        for (RacingCar car : result) {
            print(car);
        }
        System.out.print("\n");
    }

    private void print(RacingCar car) {
        for (int i = 0; i < car.movements(); i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
