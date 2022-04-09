package racingcar;

import java.util.List;

public class OutputView {

    private static final String CAR_MOVEMENT_MARKER = "-";

    public void printCurrentCarMovements(List<Integer> carCurrentLocations) {
        for (Integer carCurrentLocation : carCurrentLocations) {
            String currentLocationsMarker = createCurrentLocationMarker(carCurrentLocation);
            System.out.println(currentLocationsMarker);
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

}
