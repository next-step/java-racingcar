package car.domain;

import car.view.PrintPlayMessage;

public class CarRacing {

    private final CarList carList;
    private final int playNumber;

    public CarRacing(CarList carList, int playNumber) {
        this.carList = carList;
        this.playNumber = playNumber;
    }

    public void playAll() {
        PrintPlayMessage.printResultStartMessage();
        for (int i = 0; i < playNumber; i++) {
            playAllCars();
        }
    }

    private void playAllCars() {
        for (int i = 0; i < carList.getCars().size(); i++) {
            carList.getCars().get(i).move();
            PrintPlayMessage.printScoreMessage(carList.getCars().get(i));
        }
    }

    public CarList getCarList() {
        return carList;
    }
}
