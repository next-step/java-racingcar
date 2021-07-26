package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    private int totalRound;
    private int nowRound;
    private List<Car> cars;
    private RandomNumberGenerator numberGenerator;


    public Racing(int carCount, int moveCount) {
        this.totalRound = moveCount;
        this.nowRound = 0;
        this.cars = IntStream.range(0, carCount).mapToObj(a -> new Car()).collect(Collectors.toList());
        this.numberGenerator = new RandomNumberGenerator();
    }

    public boolean isEnd() {
        return nowRound == totalRound;
    }

    public CarsDTO play() {
        this.nowRound++;
        CarsDTO carsDTO = new CarsDTO();
        for (Car car : cars) {
            car.move(numberGenerator.generate());
            carsDTO.add(car.getNowPosition());
        }
        return carsDTO;
    }
}
