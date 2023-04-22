package race.step3.view;

import race.step3.domain.DistanceStatus;

import java.util.ArrayList;

public class ResultView {
    private static final String RESULT = "실행 결과";
    private static final String DISTANCE = "-";

    public void printCarsDistance(ArrayList<ArrayList<DistanceStatus>> carsDistanceStatus) {
        System.out.println(RESULT);
        for (ArrayList<DistanceStatus> carTotalDistanceStatus : carsDistanceStatus) {
            printCarDistance(carTotalDistanceStatus);
            System.out.println();
        }
    }

    private void printCarDistance(ArrayList<DistanceStatus> carTotalDistanceStatus) {
        for (DistanceStatus distanceStatus : carTotalDistanceStatus) {
            printDistance(distanceStatus);
            System.out.println();
        }
    }

    private void printDistance(DistanceStatus distanceStatus) {
        for (int i = 0; i < distanceStatus.getDistanceStatus(); i++) {
            System.out.print(DISTANCE);
        }
    }
}
