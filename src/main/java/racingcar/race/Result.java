package racingcar.race;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void racingStartAndPrint(RacingModel racingModel, RacingCars cars) {
        System.out.println("실행 결과");

        for (int trys = 0; trys < racingModel.getTryCount(); trys++) {
            cars.racingStart(randomNumberGenerator);
            ResultView.printEachRacingStep(cars);
        }
    }

    public List<Car> judgeWinner(RacingCars cars) {
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

    private static boolean isExistSameWinner(List<Car> racingCars, Car winnerCar) {
        return racingCars.size() > 1 && (winnerCar.getPosition() == racingCars.get(1).getPosition());
    }

    private static void addSameWinner(List<Car> result,  List<Car> racingCars) {
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
