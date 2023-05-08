package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public void displayResults(List<Car> cars) {
        int trialCount = cars.get(0).getTrialCount();

        for (int i = 0; i < trialCount; i++) {
            displayColumn(cars, i);
            System.out.println();
        }
    }

    private void displayColumn(List<Car> cars, int columnIndex) {
        for (Car car : cars) {
            System.out.printf("%s : ", car.getName());
            System.out.println(getPositionLine(car, columnIndex));
        }
    }

    public String getResults(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        int trialCount = cars.get(0).getTrialCount();

        for (int i = 0; i < trialCount; i++) {
            sb.append(getColumn(cars, i));
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String getColumn(List<Car> cars, int columnIndex) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(car.getName())
                    .append(" : ")
                    .append(getPositionLine(car, columnIndex))
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

            if(max < lastPosition) {
                max = lastPosition;
            }
        }
        return max;
    }

    private String getWinner(List<Car> cars, int biggestLastPosition) {
        ArrayList<String> winnerList = new ArrayList<>();

        for (Car car : cars) {
            int lastPosition = car.getLastPosition();

            if(lastPosition == biggestLastPosition)
                winnerList.add(car.getName());
        }

        return String.join(", ", winnerList);
    }

}
