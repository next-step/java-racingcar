package im.juniq.racingcar.domain;

public class Name implements Comparable<Name> {
	private static final int CAR_NAME_LENGTH_LIMIT = 5;
	private String name;

	public Name(String name) {
		checkCarName(name);
		this.name = name;
	}

	private void checkCarName(String name) {
		if (name.length() > CAR_NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
		}
	}

	public String value() {
		return name;
	}

	@Override
	public int compareTo(Name o) {
		return name.compareTo(o.name);
	}
}
