package step5.domain.race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step5.domain.car.Position;

public class CarPositionMap {
	Map<String, Position> carPositionMap;

	public CarPositionMap() {
		carPositionMap = new HashMap<>();
	}

	public List<String> getCurrentWinnerName() {
		List<String> winnerNames = new ArrayList<>();
		Position maxPosition = Position.getMaxPosition(this.getCarPositions());
		this.getCarPositionMap().forEach((key, value) -> {
			if (value.equals(maxPosition)) {
				winnerNames.add(key);
			}
		});
		return winnerNames;
	}

	public Map<String, Position> getCarPositionMap() {
		return this.carPositionMap;
	}

	private List<Position> getCarPositions() {
		return new ArrayList<>(carPositionMap.values());
	}

	public void writeCarPosition(String name, Position position) {
		this.carPositionMap.put(name, position);
	}
}
