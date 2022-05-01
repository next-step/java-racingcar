import domain.Car;
import domain.Cars;
import domain.Race;
import view.InputView;
import view.ResultView;

import java.util.List;

public class main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        System.out.println("경주할 자동차 이름을 입력하세요 : ");
        String carNames = inputView.getCarNames();

        System.out.println("시도할 회수는 몇 회인가요? : ");
        int rounds = inputView.getNumberOfRounds();

        prepareRace(carNames, rounds);
    }

    public static void prepareRace(String carNames, int rounds) {
        List<Car> cars = Cars.create(carNames);
        Race race = new Race(cars, rounds);

        start(race);
    }

    public static void start(Race race) {
        ResultView resultView = new ResultView();
        List<Car> cars = race.getCars();

        System.out.println("실행 결과");

        for (int i = 0; i < race.getTurns(); i++) {
            race.beginTurn(cars);
            resultView.printTurnResult(cars);
            System.out.println();
        }
        finish(race);
    }

    public static void finish(Race race) {
        ResultView resultView = new ResultView();
        resultView.printFinalResult(race.getWinner(race));
    }

}
