package racingcar;

import java.util.List;

public class OutputView {

    private static final String CAR_MOVEMENT_MARKER = "-";

    private static final String CAR_LOCATION_RESULT_FORMAT = "%5s : %s\n";

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
}
