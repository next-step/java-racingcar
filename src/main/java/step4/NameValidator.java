package step4;

public class NameValidator {
	private static final int NAME_LENGTH_LIMIT = 5;
	private static final String SEPARATOR = ",";

	public static String[] splitValidName(String carsName) {
		String[] names = carsName.split(SEPARATOR);
		for (String name : names) {
			isNameLengthOverLimit(name);
		}
		return names;
	}

	private static String isNameLengthOverLimit(String name) {
		if (name.length() <= NAME_LENGTH_LIMIT) {
			return name;
		}
		throw new IllegalArgumentException("이름은 최대 5자까지 입력 가능합니다.");
	}

}
