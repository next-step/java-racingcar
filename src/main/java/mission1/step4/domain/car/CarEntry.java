package mission1.step4.domain.car;

import java.util.*;
import java.util.stream.Collectors;

public class CarEntry implements Iterable<Car> {

    private List<Car> carEntry = new ArrayList<>();

    public void regist(Car car) {
        if (Objects.isNull(car)) {
            throw new IllegalArgumentException("엔트리 등록시 차량 인자값은 필수 입니다.");
        }

        carEntry.add(car);
    }

    public List<Car> getRaceWinner() {
        int topProgress = carEntry.stream()
                .map(Car::getProgress)
                .max((progress1, progress2) -> progress1 - progress2)
                .orElseThrow(() -> new IllegalStateException("엔트리에 등록된 차량이 존재하지 않습니다."));

        return carEntry.stream()
                        .filter((car) -> car.isWinnerCar(topProgress))
                        .collect(Collectors.toList());
    }

    @Override
    public Iterator iterator() {
        return carEntry.iterator();
    }
}




