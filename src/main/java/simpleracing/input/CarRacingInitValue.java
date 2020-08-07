package simpleracing.input;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRacingInitValue {
	private Integer carCount;
	private Integer tryCount;
	private List<String> names;

	public void setNames(List<String> names) {
		this.names = names;
	}

	public int getCarCount() {
		if (carCount != null) {
			return carCount;
		}
		return names == null || names.size() == 0 ? 0 : names.size();
	}
}
