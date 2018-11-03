package racinggame;

/**
 * Created by hspark on 03/11/2018.
 */
public enum InputType {
	CAR_AMOUNT("자동차 대수는 몇 대 인가요?"),
	TRY_COUNT("시도할 회수는 몇 회 인가요?");

	private String comment;

	InputType(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
}
