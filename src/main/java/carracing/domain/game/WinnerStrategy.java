package carracing.domain.game;

import carracing.domain.car.Car;

import java.util.List;

public interface WinnerStrategy {
	List<Car> winners(List<Car> cars);
}
