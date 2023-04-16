package racing.domain;

import racing.domain.Car;
import racing.dto.GameResult;
import racing.util.RandomInt;

import java.util.ArrayList;
import java.util.List;

public class Cars { // 일급컬렉션
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public GameResult playOnceTurn() {
        List<Integer> onceResult = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            this.cars.get(i).move(RandomInt.getPossibleInt());
            onceResult.add(this.cars.get(i).getLocation());
        }
        return new GameResult(onceResult);
    }
}
