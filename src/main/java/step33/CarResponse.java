package step33;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarResponse {
    private List<Integer> carsSize;

    public CarResponse(List<Integer> carsSize) {
        this.carsSize = carsSize;
    }


    public static CarResponse of(List<Integer> carsSize) {
        return new CarResponse(carsSize);
    }

    public List<String> getResult() {
        return carsSize.stream()
                .map(CarResponse::apply)
                .collect(
                        Collectors.toList());
    }

    private static String apply(int index) {
        return IntStream.range(0, index)
                .mapToObj(i -> "-")
                .collect(
                        Collectors.joining());
    }
}
