package car.domain;

import car.CarPlay;
import car.view.CarPlayMessage;

import java.util.List;

public class CarRacing {

    private static final int RANDOM_MAX = 10;
    private static final int MIN_NUMBER = 3;
    private final CarList carList;
    private final int playNumber;

    public CarRacing(CarList carList, int playNumber){
        this.carList = carList;
        this.playNumber = playNumber;
        carAllPlay();
    }

    public void carAllPlay(){
        CarPlayMessage.carPlayMessage("실행결과");
        for(int i = 0; i < playNumber; i++) {
            carPlay();
            CarPlayMessage.carPlayMessage("");
        }
    }

    private void carPlay(){
        for(int i = 0; i < carList.getCarNameList().size(); i++){
            int number = carList.getCarNameList().get(i).getPosition();
            if(RandomNumber.getRandomNumber(RANDOM_MAX) > MIN_NUMBER) {
                number++;
            }
            carList.getCarNameList().set(i, new Car(carList.getCarNameList().get(i).getName(), number));
            CarPlayMessage.playScoreMessage(carList.getCarNameList().get(i).getName(), number);
        }
    }

    public CarList getCarList(){
        return carList;
    }
}
