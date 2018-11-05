package racinggame.domain;

import racinggame.domain.car.CarDTO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hspark on 04/11/2018.
 */
public class RacingGameResult {
	private List<CarDTO> cars;

	public RacingGameResult(List<CarDTO> cars) {
		this.cars = cars;
	}

	public List<CarDTO> getCarDTOList() {
		return cars;
	}

	public List<CarDTO> getTopRankingCarDTOList() {
		final int maxPosition = getMaxPosition();
		return getSamePositionCarDTOList(maxPosition);
	}

	public List<CarDTO> getSamePositionCarDTOList(final int standardPosition) {
		return getCarDTOList().stream().filter(car -> car.isEqualPosition(standardPosition)).collect(Collectors.toList());
	}

	public int getMaxPosition() {
		return Collections.max(getCarDTOList(), Comparator.comparing(CarDTO::getPosition)).getPosition();
	}
}
