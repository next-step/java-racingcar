package view;

public class InputDto {
	private Integer count;
	private String[] carNames;

	public InputDto(final Integer count, final String[] carNames) {
		this.count = count;
		this.carNames = carNames;
	}

	public Integer getCount() {
		return count;
	}

	public String[] getCarNames() {
		return carNames;
	}
}
