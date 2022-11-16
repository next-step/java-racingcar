package laststep.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import laststep.domain.Car;
import laststep.domain.Cars;

public class CarFactory {

    public Cars makeCars(List<String> participants) {
        checkDuplicatedName(participants);
        List<Car> cars = participants.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private void checkDuplicatedName(List<String> participants) {
        Set<String> set = new HashSet<>(participants);
        if (set.size() != participants.size()) {
            throw new IllegalArgumentException("중복되지 않는 이름을 입력해주세요");
        }
    }
}
