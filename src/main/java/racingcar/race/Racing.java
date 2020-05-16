package racingcar.race;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private List<Car> carList = new ArrayList<>();
    private Dice dice;
    private int gameCount = 0;

    public Racing(Dice dice, int racingCount) {
        this.gameCount = racingCount;
        this.dice = dice;
    }

    public void joinRace(int carCount) {
        for(int i = 0 ; i < carCount ; i++) {
            carList.add(new Car());
        }
    }

    public void start(GameResultReceiver receiver) {

        receiver.notifyFinishRace(getRaceResult());
    }

    private List<Integer> getRaceResult() {
        return carList.stream().map(Car::getPosition).collect(Collectors.toList());
    }

}
