package domain;

import util.InputView;
import util.Validation;

public class User {
	private String carList = "";
	private String repeatTime = "";

	public String getCarList() {
		return carList;
	}

	public String getRepeatTime() {
		return repeatTime;
	}

	public void setCarList() {
		boolean determination = false;
		while (!determination) {
			carList = InputView.getCarList();
			determination = Validation.isValidCarList(carList);
		}
	}

	public void setRepeatTime() {
		boolean determination = false;
		while (!determination) {
			repeatTime = InputView.getRepeatTime();
			determination = Validation.isValidRepeatTime(repeatTime);
		}
	}
}
