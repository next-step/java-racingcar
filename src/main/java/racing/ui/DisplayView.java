package racing.ui;

import racing.vehicle.Cars;

public class DisplayView implements View {

    public final String RACE_START_MESSAGE = "실행 결과";
    public final String UNIT_DISPLAYING_LABS_OF_CAR = "-";

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
        cars.getCarPositions().stream().map(UNIT_DISPLAYING_LABS_OF_CAR::repeat).forEach(this::display);
    }
}
