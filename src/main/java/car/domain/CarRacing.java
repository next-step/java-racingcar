package car.domain;

import car.view.PrintPlayMessage;

public class CarRacing {

    private final CarList carList;
    private final int playNumber;

    public CarRacing(CarList carList, int playNumber){
        this.carList = carList;
        this.playNumber = playNumber;
        playAll();
    }

    public void playAll(){
        PrintPlayMessage.printResultStartMessage();
        for(int i = 0; i < playNumber; i++) {
            playAllCars();
        }
    }

    private void playAllCars(){
        for(int i = 0; i < carList.getCarNameList().size(); i++){
            Car car = new Car(carList.getCarNameList().get(i).getName(), carList.getCarNameList().get(i).getPosition());
            car.move();
            carList.getCarNameList().set(i, car);
            PrintPlayMessage.printScoreMessage(car);
        }
    }

    public CarList getCarList(){
        return carList;
    }
}
