package step2;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {

    private List<Car> cars;

    public RacingWinner(List<Car> cars) {
        this.cars = cars;
    }

    public String maxPostionCarName(){
        int winnerPostion = maxPosition();
        return cars.stream()
                .filter(f -> isWinnerPosition(f, winnerPostion))
                .map(Car::name)
                .collect(Collectors.joining(", "));
    }

    public int maxPosition(){
        return cars.stream()
                .mapToInt(v -> v.lastCarPosition())
                .max()
                .getAsInt();
    }

    private boolean isWinnerPosition(Car car, int winnerPostion){
        return car.lastCarPosition() == winnerPostion;
    }

}
