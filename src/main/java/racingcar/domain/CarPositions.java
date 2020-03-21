package racingcar.domain;

import java.util.List;

public class CarPositions {

    private final List<int[]> carPositions;
    private final StringBuilder view;

    public CarPositions(List<int[]> carPositions) {
        this.carPositions = carPositions;
        view = new StringBuilder();
    }

    public String getResult() {
        print(carPositions);
        return view.toString();
    }

    private void print(List<int[]> carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            loopCars(carPositions.get(i));
        }
    }

    private void loopCars(int[] carPosition) {
        for (int i : carPosition) {
            writeCarPosition(i);
            view.append(RacingGameConstant.CARRIAGE_RETURN);
        }
        view.append(RacingGameConstant.CARRIAGE_RETURN);
    }

    private void writeCarPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            view.append(RacingGameConstant.CAR_MARKER);
        }
    }

}

