package racingcar.race;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private ResultView resultView;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public Result(ResultView resultView) {
        this.resultView = resultView;
    }

    public void racingStartAndPrint(RacingModel racingModel, RacingCars cars) {
        System.out.println("실행 결과");
        for (int trys = 0; trys < InputView.tryCount; trys++) {
            racingModel.racingStart(cars, randomNumberGenerator);
            resultView.printEachRacingStep();
        }
        printWinner(racingModel, cars);
    }

    public void printWinner(RacingModel racingModel, RacingCars cars) {
        List<Car> winnerCar = judgeWinner(cars);

        RacingCars winner = new RacingCars(winnerCar);
        resultView.printWinner(winner);
    }

    private List<Car> judgeWinner(RacingCars cars) {
        List<Car> result = new ArrayList<>();

        List<Car> racingCars =
                 cars.getRacingCars().stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .collect(Collectors.toList());

        Car winnerCar = racingCars.get(0);
        result.add(winnerCar);
        if (isExistSameWinner(racingCars, winnerCar))  {
            addSameWinner(result, racingCars);
        }
        return result;
    }

    private boolean isExistSameWinner(List<Car> racingCars, Car winnerCar) {
        return racingCars.size() > 1 && (winnerCar.getPosition() == racingCars.get(1).getPosition());
    }

    private void addSameWinner(List<Car> result,  List<Car> racingCars) {
        for (int carOrder = 1; carOrder < racingCars.size(); carOrder++) {
            addSameWinner(result, racingCars, carOrder);
        }
    }

    private static void addSameWinner(List<Car> result, List<Car> racingCars, int carOrder) {
        if (isSamePositionOfWinner(racingCars, carOrder)) {
            result.add(racingCars.get(carOrder));
        }
    }

    private static boolean isSamePositionOfWinner(List<Car> racingCars, int carOrder) {
        return racingCars.get(0).getPosition() == racingCars.get(carOrder).getPosition();
    }
}
