package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.RaceHistory;
import racingcar.domain.car.Car;

public class ResultView {

    public static final String INTRO = System.lineSeparator() + "실행 결과";
    public static final String POSITION = "-";
    public static final String NEWLINE = System.lineSeparator();
    public static final String TWO_NEWLINES = System.lineSeparator() + System.lineSeparator();
    public static final String END = "\0";

    private static String carToString(Car car) {
        // extract data from Car instance
        String name = car.getStringName();
        int position = car.getIntPosition();
        String positionString = new String(new char[position]).replace(END, POSITION);
        // build string representation
        return name + " : " + positionString;
    }

    private static String carsToString(Cars cars) {
        List<Car> carList = cars.getCars();
        List<String> carStrings = carList.stream().map(ResultView::carToString)
                .collect(Collectors.toList());
        return String.join(NEWLINE, carStrings);
    }

    public static void printRaceResult(RaceHistory raceHistory) {
        String raceResultString = getRaceResultString(raceHistory);
        System.out.println(INTRO);
        System.out.println(raceResultString);
    }

    private static String getRaceResultString(RaceHistory raceHistory) {
        List<Cars> history = raceHistory.getHistory();
        List<String> carsStrings = history.stream().map(ResultView::carsToString)
                .collect(Collectors.toList());
        return String.join(TWO_NEWLINES, carsStrings);
    }
}
