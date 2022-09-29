package racing.view;

import racing.model.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameRequest {

	private static final String SPLIT_NAME_DELIMITER = ",";
	private final List<Name> names;
	private final int times;

	public GameRequest(String names, int times) {
		this.names = splitNames(names);
		this.times = times;
	}

	private List<Name> splitNames(String names) {
		return Arrays.stream(names.split(SPLIT_NAME_DELIMITER)).map(Name::new).collect(Collectors.toList());
	}

	public List<Name> getNames() {
		return names;
	}

	public int getTimes() {
		return times;
	}
}
