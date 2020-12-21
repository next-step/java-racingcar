package step3.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    private Cars cars;

    public void init(int createCarCount, int moveCount) {
        cars = new Cars();
        cars.carRegistration(createCarCount);
        numberOfCarMove(moveCount);
    }

    protected void carsMove() {
        cars.getCars().forEach(s -> s.move(new CarMovingStrategy()));
    }

    private void numberOfCarMove(int moveCount) {
        IntStream.range(0,moveCount).forEach(i -> carsMove());
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
