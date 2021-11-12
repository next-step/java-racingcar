package step3.domain;

import java.util.ArrayList;

public class CarHistoryList extends ArrayList<CarHistoryList.CarStatus> {

    public int getPosition(int round) {
        return get(round).position;
    }

    public int getLastPosition() {
        if (size() == 0) return 0;
        return get(size() - 1).position;
    }

    public void add(CarOperation carOperation, int position) {
        add(CarStatus.of(carOperation, position));
    }

    static class CarStatus {
        private CarOperation caroperation;
        private int position;

        private static CarStatus of(CarOperation carOperation, int position) {
            CarStatus carStatus = new CarStatus();
            carStatus.caroperation = carOperation;
            carStatus.position = position;
            return carStatus;
        }


    }

}