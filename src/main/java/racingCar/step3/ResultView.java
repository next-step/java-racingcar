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
        System.out.println(car.print());
    }
}
