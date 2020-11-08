package step5.client.worker.interfaces.render;

import step5.client.worker.domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step5.client.worker.interfaces.render.ViewString.*;

public class RoundResultViewRender implements ViewRender {
    private final List<Car> cars;

    public RoundResultViewRender(final List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String render() {
        return createRoundResultView() + NEWLINE;
    }

    private String createRoundResultView() {
        return cars.stream()
                .map(this::createCarResult)
                .collect(Collectors.joining());
    }

    private String createCarResult(final Car car) {
        return createCarNameView(car.getName()) + createMovingDistanceView(car.getPosition()) + NEWLINE;
    }

    private String createCarNameView(final String name) {
        return name + SPACE + DELIMITER + SPACE;
    }

    private String createMovingDistanceView(final int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> String.valueOf(MOVE_CHAR))
                .collect(Collectors.joining());
    }
}
