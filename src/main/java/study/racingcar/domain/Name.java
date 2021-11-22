package study.racingcar.domain;

public class Name {
	private static final int NAME_MAX_LENGTH = 5;
	private static final String CAR_NAME_LENGTH_MESSAGE_FRONT = "자동차의 이름은 ";
	private static final String CAR_NAME_LENGTH_MESSAGE_BACK = "자를 초과할 수 없습니다.";

	private final String name;

	public Name(String name) {
		this.name = name;
	}

	public void checkLength() {
		if(this.name.length() > NAME_MAX_LENGTH){
			throw new IllegalArgumentException(CAR_NAME_LENGTH_MESSAGE_FRONT + NAME_MAX_LENGTH + CAR_NAME_LENGTH_MESSAGE_BACK);
		}
	}
}
