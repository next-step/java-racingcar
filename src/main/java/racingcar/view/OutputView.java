package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;
import racingcar.domain.round.Round;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String CAR_POSITION = "-";
    private static final String NAME_DELIMITER = ", ";

    private static void printPosition(CarPosition position) {
        for (int i = 0; i < position.getPosition(); i++) {
            System.out.print(CAR_POSITION);
        }
        System.out.println();
    }

    private static void printName(CarName name) {
        System.out.print(name.getName());
    }

    public static void printGameResult(List<Round> rounds) {
        System.out.println("실행 결과");

        for (Round round : rounds) {
            printRoundResult(round);
        }

        printWinner(rounds.get(rounds.size() - 1).getCars().getWinnerCars());
    }

    private static void printWinner(List<Car> cars) {
        System.out.print(getNames(cars));
        System.out.println("이(가) 최종 우승 했습니다.");
    }

    private static String getNames(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getName().getName())
                .collect(Collectors.joining(NAME_DELIMITER));
    }

    private static void printRoundResult(Round round) {
        for (Car car : round.getCars().getCars()) {
            printCarResult(car);
        }
        System.out.println();
    }

    private static void printCarResult(Car car) {
        printName(car.getName());
        System.out.print(NAME_POSITION_DELIMITER);
        printPosition(car.getPosition());
    }
}
