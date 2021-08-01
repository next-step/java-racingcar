package step4.view.result;

import step4.car.Car;
import step4.car.Cars;
import step4.car.Position;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String MARKER = "-";

    public void printProgressOfRace(Cars cars) {
        int size = cars.size();
        for (int i = 0; i < size; i++) {
            Car car = cars.get(i);
            System.out.println(progressOfRace(car));
        }
        System.out.println();
    }

    private String progressOfRace(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(" : ");
        sb.append(getCarPosition(car));

        return sb.toString();
    }

    private String getCarPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        Position position = car.getPosition();
        int currentPosition = position.getValue();

        for (int i = 0; i < currentPosition; i++) {
            sb.append(MARKER);
        }
        return sb.toString();
    }

    public void printWinnerOfRacing(String winnersName) {
        System.out.println(String.format("%s가 최종 우승했습니다.", winnersName));
    }
}
