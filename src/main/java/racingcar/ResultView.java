package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public void displayResults(CarCollection carCollection) {
        System.out.println(getResults(carCollection));
    }

    public String getResults(CarCollection carCollection) {
        StringBuilder sb = new StringBuilder();
        int trialCount = carCollection.getCars().get(0).getTrialCount();

        for (int i = 0; i < trialCount; i++) {
            sb.append(getColumn(carCollection, i));
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String getColumn(CarCollection carCollection, int index) {
        StringBuilder sb = new StringBuilder();

        for (Car car : carCollection.getCars()) {
            sb.append(car.getName())
                    .append(" : ")
                    .append(getPositionLine(car, index))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }


    private String getPositionLine(Car car, int columnIndex) {
        return "-".repeat(car.getPosition(columnIndex));
    }

    public String getWinnerMessage(List<Car> cars) {
        String winner = getWinner(cars, getBiggestLastPosition(cars));

        return winner + "가 최종 우승했습니다.";
    }

    private int getBiggestLastPosition(List<Car> cars) {
        int max = -1;

        for (Car car : cars) {
            int lastPosition = car.getLastPosition();

            if (max < lastPosition) {
                max = lastPosition;
            }
        }
        return max;
    }

    private String getWinner(List<Car> cars, int biggestLastPosition) {
        ArrayList<String> winnerList = new ArrayList<>();

        for (Car car : cars) {
            int lastPosition = car.getLastPosition();

            if (lastPosition == biggestLastPosition) {
                winnerList.add(car.getName());
            }
        }

        return String.join(", ", winnerList);
    }

}
