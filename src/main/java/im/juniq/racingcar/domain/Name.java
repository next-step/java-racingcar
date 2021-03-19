package im.juniq.racingcar.domain;

public class Name implements Comparable<Name> {
	private String name;

	public Name(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Name o) {
		return name.compareTo(o.name);
	}
}
