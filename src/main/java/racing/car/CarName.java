package racing.car;

import java.util.Objects;

public class CarName implements CharSequence {
	private static final int MAX_LENGTH = 5;
	private static final String MESSAGE_MAX_LENGTH_OVER = "차 이름은 무조건 5자 이하여야 합니다";
	private static final String MESSAGE_EMPTY = "차 이름이 비어있으면 안됩니다.";
	private static final String MESSAGE_CONTAIN_SPACE = "차 이름에 공백이 들어가서는 안됩니다";
	private static final String SPACE = " ";
	private final String name;

	public CarName(String name) {
		this.name = name;
		validation(name);
	}

	public static void validation(String name) throws IllegalArgumentException {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(MESSAGE_MAX_LENGTH_OVER);
		}

		if (name.length() == 0) {
			throw new IllegalArgumentException(MESSAGE_EMPTY);
		}

		if (name.contains(SPACE)) {
			throw new IllegalArgumentException(MESSAGE_CONTAIN_SPACE);
		}
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CarName) {
			return Objects.equals(this.name, ((CarName) obj).name);
		}

		if (obj instanceof String) {
			return Objects.equals(this.name, obj);
		}

		return super.equals(obj);
	}

	@Override
	public char charAt(int index) {
		return this.name.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return this.name.subSequence(start, end);
	}

	@Override
	public int length() {
		return this.name.length();
	}
}
