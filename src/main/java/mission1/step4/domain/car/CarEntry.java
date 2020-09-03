package mission1.step4.domain.car;

import mission1.step4.util.CarUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarEntry implements Iterable<Car>{
    private List<Car> carEntry = new ArrayList<>();
    private int topProgress = 0;

    public void regist(Car car) {
        if (Objects.isNull(car)) {
            throw new IllegalArgumentException("엔트리 등록시 차량 인자값은 필수 입니다.");
        }

        carEntry.add(car);
    }

    public Car getCar(int idx) {
        if (carEntry.size() < idx) {
            throw new IllegalArgumentException("엔트리에 등록된 차량의 숫자보다 높은 인덱스를 인자값 으로 허용할 수 없습니다.");
        }

        return carEntry.get(idx);
    }

    public void move(int randomValue) {
        carEntry.forEach((car) -> {
            car.move(randomValue);
            if (car.getProgress() > topProgress) {
                topProgress = car.getProgress();
            }
        });
    }

    public List<Car> getRaceWinner() {
        return  carEntry.stream()
                        .filter((car) -> car.getProgress() >= topProgress)
                        .collect(Collectors.toList());
    }

    @Override
    public Iterator iterator() {
        return carEntry.iterator();
    }
}


