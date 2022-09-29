package racing.model;

import java.util.Objects;

public class Name {

	private String name;

	public Name(String name) {
		if (!isValid(name)) {
			throw new IllegalArgumentException("이름은 공백이거나, 5자 이상일 수 없습니다.");
		}
		this.name = name;
	}

	private boolean isValid(String name) {
		return !name.isBlank() && name.length() < 5;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Name name1 = (Name) o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
