package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {

	private final List<Integer> positions;

	public Result(List<Integer> positions) {
		this.positions = new ArrayList<>(positions);
	}

	public List<Integer> getPositions() {
		return Collections.unmodifiableList(positions);
	}
}
