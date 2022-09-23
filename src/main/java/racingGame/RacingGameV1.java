package racingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGameV1 {
    private int carNum;
    private int tryNUm;

    public RacingGameV1(int carNum, int tryNum) {
        this.carNum = carNum;
        this.tryNUm = tryNum;
    }

    public List<Car> start() {
        String carMark = "-";
        List<String> carMarks = new ArrayList<>();
        for (int i = 0; i < tryNUm; i++) {
            carMarks.add(carMark);
        }
        List<Car> Cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            Cars.add(new Car(carMarks));
        }
        return Cars;
    }
}
