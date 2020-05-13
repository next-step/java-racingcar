package CarRacing;

import java.util.ArrayList;

public class CarRacingGame {

    private CarRacingOption carRacingOption;
    private final int  MOVE_CHECK_VALUE = 4;
    private ArrayList<Car> carList;
    private CarRacingView carRacingView = new CarRacingView();

    public CarRacingGame(CarRacingOption carRacingOption) {
        this.carRacingOption = carRacingOption;
    }

    public void gameStart() {
        gameInit();
        for(int i=0 ; i < carRacingOption.getGameCount() ; i++) {
            carList.stream().forEach( car -> {
                if (moveCheck() == true) {
                    car.move(Direction.FORWARD);
                }
            });
            carRacingView.view(carList);
        }
    }

    private boolean moveCheck() {
        return RandomValue.getRandomValue() >= MOVE_CHECK_VALUE ? true : false;
    }

    private void gameInit() {
        carList = new ArrayList<Car>();
        for(int i=0 ; i<carRacingOption.getCarCount() ; i++) {
            carList.add(new Car(String.valueOf(i), new Position()));
        }
    }
}
