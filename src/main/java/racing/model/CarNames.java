package racing.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racing.util.StringValid;

public class CarNames {

	private static final String RACING_CAR_NAME_SEPARATOR = ",";
	private final List<CarName> names;

	public CarNames(String userInputString) {

		validationCarNames(userInputString);

		this.names = getCarNameList(userInputString);
	}

	/**
	 * 유저가 입력한 레이싱 자동차 나열 문자열 벨리데이션 메서드
	 * @param carNames: 유저가 입력한 문자열
	 */
	private void validationCarNames(String carNames) {

		if (StringValid.isEmptyStr(carNames)) {
			throw new IllegalArgumentException("주행할 자동차 이름들을 입력해 주세요."); //주할 자동차(쉼표(,)를 기준으로 구분)으로 입력해 주세요.
		}

		if (!carNames.contains(RACING_CAR_NAME_SEPARATOR)) {
			throw new IllegalArgumentException("주행할 자동차 이름들을 쉼표(,)를 기준으로 구분 입력해 주세요."); //주할 자동차
		}
	}

	/**
	 * 유저가 입력한 자동차 문자열을 리스트로 변환 메서드
	 * @param carNames: 유저가 입력한 문자열
	 * @return carNameList: 자동차 명 리스트 리턴
	 */
	private List<CarName> getCarNameList(String carNames) {

		return namesToList(carNames).stream()
			.map(CarName::new)
			.collect(Collectors.toList());
	}

	/**
	 * 문자열을 시스템 기준(,)으로 잘라 리스트 리턴 메서드
	 * @param carNames: 유저가 입력한 문자열
	 * @return carNameList: 자동차 명 리스트 리턴
	 */
	private List<String> namesToList(String carNames) {

		return Arrays.asList(carNames.split(RACING_CAR_NAME_SEPARATOR));
	}

	/**
	 * 자동차 명 리스트 리턴 메서드
	 * @return 자동차 명 리스트 리턴
	 */
	public List<CarName> getCarNames() {

		return this.names;
	}
}
