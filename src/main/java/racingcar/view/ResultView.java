package racingcar.view;

import racingcar.model.CarLocationResult;
import racingcar.model.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String CAR_MOVEMENT_MARKER = "-";

    private static final String CAR_LOCATION_RESULT_FORMAT = "%5s : %s\n";

    private static final String WINNERS_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";

    public void printCurrentCarMovements(List<CarLocationResult> carCurrentLocations) {
        for (CarLocationResult carCurrentLocation : carCurrentLocations) {
            String carName = carCurrentLocation.getCarName();
            String currentLocationsMarker = createCurrentLocationMarker(carCurrentLocation.getCurrentLocation());
            System.out.printf(CAR_LOCATION_RESULT_FORMAT, carName, currentLocationsMarker);
        }
        System.out.println();
    }

    private String createCurrentLocationMarker(Integer carCurrentLocation) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while(count < carCurrentLocation) {
            stringBuilder.append(CAR_MOVEMENT_MARKER);
            count++;
        }
        return stringBuilder.toString();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printWinners(List<CarName> winners) {
        List<String> winnersAsString = winners.stream().map(CarName::getName).collect(Collectors.toList());
        System.out.printf(WINNERS_MESSAGE_FORMAT, String.join(", ", winnersAsString));
    }
}
