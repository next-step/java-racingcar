package racingcar;


import racingcar.service.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racingcar.service.Car.race;
import static racingcar.view.InputView.input;
import static racingcar.view.ResultView.view;
import static racingcar.view.ResultView.viewWinners;

public class RacingCarApplication {
    public static final Random random = new Random();

    public static void main(String[] args) {
        final var input = input();
        String[] carNames = (String[]) input.get(0);
        int labs = (int) input.get(1);

        List<Car> racingCars = new ArrayList<>();
        for(int car=0; car < carNames.length; car++){
            racingCars.add(new Car(carNames[car], race(labs)));
        }

        view(racingCars);
        viewWinners(getWinners(racingCars));
    }

    public static List<Car> getWinners(List<Car> racingCars){
        int winnerScore = 0;
        for(Car car : racingCars){
            int lastState = car.getState().get(car.getState().size() - 1);
            if(winnerScore < lastState){
                winnerScore = lastState;
            }
        }

        List<Car> winners = new ArrayList<>();
        for(Car car : racingCars){
            int lastState = car.getState().get(car.getState().size() - 1);
            if(winnerScore == lastState){
                winners.add(car);
            }
        }

        return winners;
    }
}
