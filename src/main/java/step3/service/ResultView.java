package step3.service;

import java.util.List;

import step3.domain.Car;

public class ResultView {

    private final int cars;
    private final int attempts;
    private final CarPlay carPlay;

    public ResultView(CarPlay carPlay, InputView inputView) {
        this.cars = inputView.getCarNumber();
        this.carPlay = carPlay;
        this.attempts = inputView.getAttempts();
    }

    public void printTotalCarStatus() {
        for (int i = 0; i < attempts; i++) {
            setPrintCarStatus();
            if (checkLastAttempt(i, attempts))
                System.out.println();
        }
    }

    private void setPrintCarStatus() {

        List<Car> updateCarList = carPlay.setCarList();

        for (int i = 0; i < cars; i++) {
            for (int j = 0; j < updateCarList.get(i).getCurrentStatus(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }


    private boolean checkLastAttempt(int idx, int attempts) {
        return idx != attempts - 1;
    }
}
