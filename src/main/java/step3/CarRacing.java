package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private List<Car> cars;

    private RaceRoulette raceRoulette = RaceRoulette.simple(9);
    private RaceResult raceResult = new RaceResult();

    public void start() {
        List<String> carNames = getCarNames();

        readyToRace(carNames);

        int totalTries = getNumOfTries();
        int currentTry = 1;
        System.out.println("실행 결과");

        while (currentTry <= totalTries) {
            tryMovingAllCars();
            displayCurrentMovingDistances();
            currentTry++;
        }

        announceRaceWinner();
    }

    private void announceRaceWinner() {
        resultView.showRaceWinner(raceResult.findRaceWinners(cars));
    }

    private List<String> getCarNames() {
        return inputView.getCarNames();
    }

    private int getNumOfTries() {
        try {
            return inputView.getNumOfTries();
        } catch (RuntimeException e){
            System.err.println("시도할 횟수는 1이상 정수 만 입력 가능합니다.");
            throw e;
        }
    }

    private void readyToRace(List<String> carNames) {
        try {
            this.cars = new ArrayList<>(carNames.size());
            carNames.forEach(it -> cars.add(new Car(it)));
        } catch(InvalidCarNameException e){
            System.err.println("자동차이름은 5자를 초과 할 수 없고 쉼표(,)로 구분하여 입력해야 합니다.");
            throw e;
        }
    }

    private void displayCurrentMovingDistances() {
        this.resultView.showRaceState(cars);
    }

    private void tryMovingAllCars() {
        this.cars.forEach(it -> it.moveIf( () -> raceRoulette.spin() >= 4 ));
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }

}
