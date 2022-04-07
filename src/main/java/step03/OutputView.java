package step03;

import java.util.List;

public class OutputView {

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";

    private static final String TRIAL_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final String CAR_MOVEMENT_MARKER = "-";

    public void printCarCountMessage() {
        System.out.println(CAR_COUNT_MESSAGE);
    }

    public void printTrialCountMessage() {
        System.out.println(TRIAL_COUNT_MESSAGE);
    }

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
