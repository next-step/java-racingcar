package racingCar;

public class ResultView {
    public void print(String str) {
        System.out.println(str);
    }

    public void print(RacingCars result) {
        System.out.print(result.toString());
    }

    private void print(RacingCar car) {
        System.out.println(car.toString());
    }
}
