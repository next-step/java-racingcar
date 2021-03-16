package ch01.step2;

public class ResultView {
    Car[] cars;

    public ResultView() {
        System.out.println("실행결과");
    }

    public ResultView(Car[] cars) {
        System.out.println("실행결과");
        this.cars = cars;
    }

    public void showResult(RacingGame racingGame) {
        int attemptCount = racingGame.getAttemptCount();
        this.cars = racingGame.getCars();
        this.print();
    }

    private void print() {
        for (int i = 0; i < cars.length; i++) {
            nullAndEmpty(cars[i], i);
        }
        System.out.println();
    }

    private void nullAndEmpty(Car car, int index) {
        if (car != null) {
            System.out.println(car.progressBar);
        }
    }

}
