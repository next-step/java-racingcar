package step3;

public class CarRacing {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private JoinedCars joinedCars;

    private RaceRoulette raceRoulette = RaceRoulette.simple(9);

    public void start() {

        readyToRace(getCarNames());

        int totalTries = getNumOfTries();
        int currentTry = 1;
        System.out.println("실행 결과");

        while (currentTry++ <= totalTries) {
            tryMovingAllCars();
            displayRaceState();
        }

        announceRaceWinner();
    }

    private String getCarNames(){
        return inputView.getCarNames();
    }

    private int getNumOfTries(){
        int value = inputView.getNumOfTries();
        if (value < 1) throw new RuntimeException("시도 횟수는 1 이상만 허용됩니다. ( 입력값 : " + value + " )");
        return value;
    }

    private void readyToRace(String carNames) {
        joinedCars = new JoinedCars(carNames);
    }

    private void tryMovingAllCars() {
        joinedCars.tryMoving(raceRoulette);
    }

    private void displayRaceState() {
        resultView.showRaceState(joinedCars);
    }

    private void announceRaceWinner() {
        resultView.showRaceWinner(joinedCars.findRaceWinner(new RaceWinnerFinder()));
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }

}
