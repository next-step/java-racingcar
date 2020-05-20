package CarRacing;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private CarRacingOption carRacingOption;
    private List<Car> carList;
    private CarRacingView carRacingView = new CarRacingView();

    public CarRacingGame(CarRacingOption carRacingOption) {
        this.carRacingOption = carRacingOption;
    }

    public void gameStart() {
        gameInit();
        for(int i=0 ; i < carRacingOption.getGameCount() ; i++) {
            carList.stream().forEach( car -> {
                car.progress(new RandomValue());
            });
            carRacingView.view(carList);
        }
    }

    private void gameInit() {
        carList = new ArrayList<Car>();
        for(int i=0 ; i<carRacingOption.getCarCount() ; i++) {
            carList.add(new Car(String.valueOf(i), new Position()));
        }
    }
}
