package racing.ui;

import racing.vehicle.Car;
import racing.vehicle.CarName;
import racing.vehicle.Cars;

import java.util.stream.Collectors;

public class DisplayView implements View {

    public final static String RACE_START_MESSAGE = "실행 결과";
    public final static String UNIT_DISPLAYING_LABS_OF_CAR = "-";
    public final static String CARS_DELIMITER = ",";
    public final static String CAR_POSITION_FORMAT = "%s : %s";
    public final static String RESULTS_FORMAT = "%s가 최종 우승했습니다.";

    @Override
    public void display(String content) {
        System.out.println(content);
    }

    public void displayEmptyLine() {
        this.display("");
    }

    public void displayRaceStart() {
        this.display(RACE_START_MESSAGE);
    }

    public void displayCarsPosition(Cars cars) {
        cars.getCars().stream().map(this::buildCarPositionString).forEach(this::display);
    }

    public void displayWinners(Cars winners) {
        String winnersName = winners.getCars().stream()
                .map(Car::getName)
                .map(CarName::toString)
                .collect(Collectors.joining(CARS_DELIMITER));
        this.display(String.format(RESULTS_FORMAT, winnersName));
    }

    private String buildCarPositionString(Car car) {
        return String.format(
                CAR_POSITION_FORMAT, car.getName(), UNIT_DISPLAYING_LABS_OF_CAR.repeat(car.getCurrentPosition()));
    }
}
