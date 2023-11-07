package racing;

public class RacingCar {

    public static void main(String[] args) {
        ResultView.print("자동차 대수는 몇 대 인가요?");
        int cars = InputView.input();
        ResultView.print("시도할 회수는 몇 회 인가요?");
        int round = InputView.input();

        Car car = new Car(cars, round);
        ResultView.print("실행 결과");
        car.race();
    }
}
