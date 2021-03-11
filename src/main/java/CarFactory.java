import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static Cars generateCars(List<String> names) {
        if (isDuplicated(names)) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }

        return new Cars(names.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public static boolean isDuplicated(List<String> names) {
        return !names.stream()
                .map(String::toString)
                .allMatch(new HashSet<>()::add);
    }
}
