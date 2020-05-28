package carracing.domain.car;

import carracing.view.CarRacingView;
import carracing.domain.RandomValue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private CarRacingOption carRacingOption;
    private List<Car> carList;
    private CarRacingView carRacingView = new CarRacingView();
    private Comparator<Car> carComparator = Comparator.comparingInt(Car::getLocation);

    public CarRacingGame(CarRacingOption carRacingOption) {
        this.carRacingOption = carRacingOption;
    }

    public void gameStart() {
        gameInit();
        for(int i=0 ; i < carRacingOption.getGameCount() ; i++) {
            carList.stream().forEach( car -> {
                car.progress(new RandomValueStrategy());
            });
            carRacingView.view(carList);
        }
        carRacingView.resultView(gameWinner(carList));
    }

    private void gameInit() {
        String[] carNames = carRacingOption.getCarNames();
        carList = new ArrayList<Car>();
        for(int i=0 ; i<carRacingOption.getCarCount() ; i++) {
            carList.add(new Car(carNames[i], String.valueOf(i) , new Position()));
        }
    }

    public List<Car> gameFinish() {
        return this.gameWinner(carList);
    }

    public List<Car> gameResult() {
        return carList;
    }

    public List<Car> gameWinner(List<Car> carList) {
        List<Car> winnersList;
        int maxPosition = carList.stream()
                            .max(carComparator)
                            .get()
                            .getLocation();

        winnersList = carList.stream()
                .filter(car -> car.getLocation() == maxPosition)
                .collect(Collectors.toList());

        return winnersList;
    }


}
