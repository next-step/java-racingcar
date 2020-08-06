package simpleracing.input;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRacingInitValue {
	private int carCount;
	private int tryCount;
	private List<String> names;

	public void setNames(List<String> names) {
		this.names = names;
		this.carCount = names.size();
	}
}
