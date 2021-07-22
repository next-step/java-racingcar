package racing.car;

import java.util.*;

public class Cars implements Iterable<Car> {
    private static final Random random = new Random();
    private List<Car> values;

    public Cars() {
        this.values = new ArrayList<>();
    }

    // 요구사항 "주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다."를 만족하기 위해
    // movement 값이 false 라면 바로 return 하도록 했습니다.
    // 제가 잘못 이해 한걸까요?

    public void moveAll(boolean movement) {
        if (!movement)
            return;
        for (Car iCar : values) {
            iCar.move(
                    new Location(random.nextInt(9))
            );
        }
    }

    public void add(Car car) {
        values.add(car);
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.iterator();
    }
}
