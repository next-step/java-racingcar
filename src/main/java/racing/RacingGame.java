package racing;

public class RacingGame {
    public static void main(String[] args) {
        int carCnt = InputView.requestNumber("자동차 대수는 몇 대 인가요?");
        int reps = InputView.requestNumber("시도할 회수는 몇 회 인가요?");

        Car[] cars = new Car[carCnt];
        for (int idx = 0; idx < carCnt; idx++) {
            cars[idx] = new Car();
        }

        Track track = new Track(cars);

        ResultView.printTitle();
        track.start(reps);
    }
}
