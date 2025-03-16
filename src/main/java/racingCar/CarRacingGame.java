package racingCar;

public class CarRacingGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final NumberVerifier numberVerifier;

    public CarRacingGame(InputView inputView, ResultView resultView, NumberVerifier numberVerifier) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.numberVerifier = numberVerifier;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        NumberVerifier numberVerifier = new NumberVerifier();
        CarRacingGame game = new CarRacingGame(inputView, resultView, numberVerifier);
        game.startGame();
    }

    private void startGame() {
        RacingCar[] cars = getParticipant();

        play(cars, inputView.requestPlayCount());
    }

    private RacingCar[] getParticipant() {
        while (true) {
            int participantCount = inputView.requestParticipant();
            try {
                validateNum(participantCount);
                return createRacingCars(participantCount);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
    }

    void validateNum(int num) {
        numberVerifier.verify(num);
    }

    RacingCar[] createRacingCars(int count) {
        return new RacingCar[count];
    }

    private void play(RacingCar[] cars, int count) {
        resultView.printResultTitle();
        for (int i=0 ; i<count ; i++) {
            moveCar(cars);
            resultView.printPlay(cars);
        }
    }

    private void moveCar(RacingCar[] cars) {
        for (RacingCar car : cars) {
            car.progress();
        }
    }
}
