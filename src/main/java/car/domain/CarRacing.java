package car.domain;

import car.view.PrintPlayMessage;

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
        PrintPlayMessage.printPlayMessage("실행결과");
        for(int i = 0; i < playNumber; i++) {
            carPlay();
            PrintPlayMessage.printPlayMessage("");
        }
    }

    private void carPlay(){
        for(int i = 0; i < carList.getCarNameList().size(); i++){
            int number = carList.getCarNameList().get(i).getPosition();
            if(RandomNumber.getRandomNumber(RANDOM_MAX) > MIN_NUMBER) {
                number++;
            }
            carList.getCarNameList().set(i, new Car(carList.getCarNameList().get(i).getName(), number));
            PrintPlayMessage.printScoreMessage(carList.getCarNameList().get(i).getName(), number);
        }
    }

    public CarList getCarList(){
        return carList;
    }
}
