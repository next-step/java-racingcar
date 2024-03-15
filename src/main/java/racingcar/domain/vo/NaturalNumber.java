package racingcar.domain.vo;

public class NaturalNumber {

	private final Integer value;

	public NaturalNumber(Integer value) {
		if (value <= 0) {
			throw new IllegalArgumentException("값은 1 이상이어야합니다.");
		}
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
