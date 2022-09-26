package racing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private static final String INPUT_CAR_COUNT_TEXT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_ROUND_COUNT_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String ROUND = "라운드";
    private static final String RESULT_TITLE = "실행 결과";
    private int rounds = 0;
    private List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.play();
    }

    public void play(int carCount, int rounds) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        this.rounds = rounds;
    }

    public int carsCount() {
        return cars.size();
    }

    public int rounds() {
        return rounds;
    }

    private void play() {
        prepare();
        for (int i = 1; i <= rounds; i++) {
            playRound();
            announceResult(i);
        }
    }

    private void prepare() {
        participateCars();
        setRounds();
    }

    private void playRound() {
        for (Car car : cars) {
            car.run();
        }
    }

    private void setRounds() {
        this.rounds = InputView.inputPositive(INPUT_ROUND_COUNT_TEXT);
    }

    private void participateCars() {
        int carCount = InputView.inputPositive(INPUT_CAR_COUNT_TEXT);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void announceResult(int round) {
        if (round == 1) ResultView.print(RESULT_TITLE);
        ResultView.print(ROUND, round);
        for (Car car: cars) {
           car.printDistance();
        }
        ResultView.printNewLine();
    }
}
