package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.RaceHistory;
import racingcar.domain.car.Car;

public class ResultView {

    public static final String POSITION = "-";
    public static final String END = "\0";
    public static final String COMMA = ", ";
    public static final String INTRO = System.lineSeparator() + "실행 결과";
    public static final String WINNER = "가 최종 우승했습니다.";
    public static final String NEWLINE = System.lineSeparator();
    public static final String TWO_NEWLINES = System.lineSeparator() + System.lineSeparator();

    public static void printRace(RaceHistory raceHistory) {
        printRaceHistory(raceHistory);
        printWinners(raceHistory);
    }

    private static void printWinners(RaceHistory raceHistory) {
        Cars finishedCars = raceHistory.getFinishedCars();
        List<Car> winners = finishedCars.findWinners();
        String winnerNames = winners.stream().map(Car::getStringName)
                .collect(Collectors.joining(COMMA));
        System.out.println(winnerNames + WINNER);
    }

    private static void printRaceHistory(RaceHistory raceHistory) {
        System.out.println(INTRO);
        System.out.println(historyToString(raceHistory));
    }

    private static String historyToString(RaceHistory raceHistory) {
        List<Cars> history = raceHistory.getHistory();
        List<String> carsStrings = history.stream().map(ResultView::carsToString)
                .collect(Collectors.toList());
        return String.join(TWO_NEWLINES, carsStrings);
    }

    private static String carToString(Car car) {
        String name = car.getStringName();
        int position = car.getIntPosition();
        String positionString = new String(new char[position]).replace(END, POSITION);
        return name + " : " + positionString;
    }

    private static String carsToString(Cars cars) {
        List<Car> carList = cars.getCars();
        List<String> carStrings = carList.stream().map(ResultView::carToString)
                .collect(Collectors.toList());
        return String.join(NEWLINE, carStrings);
    }
}
