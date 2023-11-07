package carracing.car;

import java.util.List;

public interface WinnerStrategy {
	List<Car> winners(List<Car> cars);
}
