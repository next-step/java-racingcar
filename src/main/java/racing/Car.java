package racing;

public class Car {
	public static final int CAR_NAME_MAX_LENGTH = 5;
	public String name;

	public Car(String name) {
		if (name.isEmpty() || name.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("자동차의 이름 길이는 0보다 크고 5보다 작거나 같아야 합니다 : " + name);
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
