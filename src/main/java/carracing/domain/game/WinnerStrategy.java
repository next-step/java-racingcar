package carracing.domain.game;

import carracing.domain.car.Cars;
import carracing.domain.car.Winners;

public interface WinnerStrategy {
	Winners winners(Cars cars);
}
