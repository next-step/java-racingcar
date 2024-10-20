package step5.domain.car;

import java.util.List;
import java.util.Objects;

public class Position {
	private int position;

	public Position(int position) {
		this.position = position;
	}

	private static Position compareMaxPosition(Position position, Position maxPosition) {
		if (isPositionBiggerThanMax(position, maxPosition)) {
			return position;
		}
		return maxPosition;
	}

	public static Position getMaxPosition(List<Position> positionList) {
		Position maxPosition = new Position(0);
		for (Position position : positionList) {
			maxPosition = compareMaxPosition(position, maxPosition);
		}
		return maxPosition;
	}

	private static boolean isPositionBiggerThanMax(Position position, Position maxPosition) {
		return position.get() > maxPosition.get();
	}

	public int get() {
		return position;
	}

	public void addPositionBySpeed(int speed) {
		this.position += speed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position1 = (Position)o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(position);
	}
}
