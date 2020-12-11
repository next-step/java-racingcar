package racing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racing.util.StringValid;

public class CarNames {

	private static final String RACING_CAR_NAME_SEPARATOR = ",";
	private List<CarName> names;

	public CarNames(String carNames) {

		validationCarNames(carNames);

		this.names = getCarNameList(carNames);
	}

	private List<CarName> getCarNameList(String carNames) {

		List<CarName> carNameList = new ArrayList<>();

		for (String carName : namesToList(carNames)) {

			carNameList.add(new CarName(carName));
		}

		return carNameList;
	}

	private void validationCarNames(String carNames) {

		if (StringValid.isEmptyStr(carNames)) {
			throw new IllegalArgumentException("주행할 자동차 이름들을 입력해 주세요."); //주할 자동차(쉼표(,)를 기준으로 구분)으로 입력해 주세요.
		}

		if (!carNames.contains(RACING_CAR_NAME_SEPARATOR)) {
			throw new IllegalArgumentException("주행할 자동차 이름들을 쉼표(,)를 기준으로 구분 입력해 주세요."); //주할 자동차
		}
	}

	private List<String> namesToList(String carNames) {

		return Arrays.asList(carNames.split(RACING_CAR_NAME_SEPARATOR));
	}
}
