package racinggame.mvc.domain;

import java.util.List;

public record RacingResult(List<Car> cars, List<Car> winners) {
}
