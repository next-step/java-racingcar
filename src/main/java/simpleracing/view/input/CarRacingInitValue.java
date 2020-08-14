package simpleracing.view.input;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRacingInitValue {
	private Integer numberOfCars;
	private Integer numberOfAttempts;
	private List<String> names;

	public void setNames(List<String> names) {
		this.names = names;
	}

	public int getNumberOfCars() {
		if (numberOfCars != null) {
			return numberOfCars;
		}

		if (names == null || names.size() == 0) {
			return 0;
		}

		return numberOfCars = names.size();
	}
}
