public class Splitter {
	private final String target;
	private final String delimiter;

	public Splitter(String target, String delimiter) {
		this.target = target;
		this.delimiter = delimiter;
	}

	public static Splitter of(String target, String delimiter) {
		return new Splitter(target, delimiter);
	}

	public String[] getNumbers() {
		return target.split(delimiter);
	}
}
