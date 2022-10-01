package racing.dto;

import racing.model.Name;
import racing.model.Position;

public class RacingResult {

	private final int position;
	private final String name;

	public RacingResult(Position position, Name name) {
		this.position = position.getPosition();
		this.name = name.getName();
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
