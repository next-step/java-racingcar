package racing.model;

import java.util.Objects;

import racing.util.StringValid;

public class CarName {

	public static final int CAR_NAME_MAX_LENGTH = 5;
	private final String name;

	public CarName(String carName) {

		this.name = setCarName(carName);
	}

	private String setCarName(String carName) {

		validationCarName(carName);

		return carName;
	}

	/**
	 * 유저가 입력한 자동차 명 벨리데이션 메서드
	 * @param carName: 생성 될 자동차 명
	 */
	private void validationCarName(String carName) {

		if (StringValid.isEmptyStr(carName)) {
			throw new IllegalArgumentException("차량 이름이 없습니다.");
		}

		if (carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("차량 이름은 최대 5자를 초과할 수 없습니다.");
		}
	}

	/**
	 * 유저가 입력한 자동차 명 리턴
	 * @return carName: 유저가 입력한 자동차 명
	 */
	public String getName() {

		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarName carName = (CarName)o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
