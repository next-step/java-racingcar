package racing;

public class RacingGame {
    public static void main(String[] args) {
        int carCnt = InputView.requestNumber("자동차 대수는 몇 대 인가요?");
        int reps = InputView.requestNumber("시도할 회수는 몇 회 인가요?");

        Track track = new Track(new RacingOption(carCnt, reps));
        track.createCars();

        ResultView.printTitle();
        track.start(reps);
    }
}
