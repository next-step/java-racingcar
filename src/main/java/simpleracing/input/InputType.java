package simpleracing.input;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public enum InputType {
	CAR_COUNT("자동차 대수는 몇 대 인가요?",
			  count -> validateCount(count, "자동차 대수는 0대 이하일 수 없습니다."),
			  (initValue, carCount) -> initValue.setCarCount(Integer.parseInt(carCount))),
	GAME_COUNT("시도할 회수는 몇 회 인가요?",
			   count -> validateCount(count, "시도할 회수는 0회 이하일 수 없습니다."),
			   (initValue, gameCount) -> initValue.setTryCount(Integer.parseInt(gameCount)));

	static {
		String numberPattern = "^[-+]?(0|[1-9][0-9]*)(\\\\.[0-9]+)?([eE][-+]?[0-9]+)?$";
		pattern = Pattern.compile(numberPattern);
	}

	final String question;
	final Consumer<String> validate;
	final BiConsumer<CarRacingInitValue, String> carRacingInitValueConsumer;

	final static Pattern pattern;


	InputType(String question, Consumer<String> validate, BiConsumer<CarRacingInitValue, String> carRacingInitValueConsumer) {
		this.question = question;
		this.validate = validate;
		this.carRacingInitValueConsumer = carRacingInitValueConsumer;
	}

	private static void validateNumber(String value) {
		Matcher matcher = pattern.matcher(value);
		boolean number = matcher.matches();

		if (!number) {
			throw new IllegalArgumentException("숫자로 입력해주세요.");
		}
	}

	private static void validateCount(String count, String exceptionMessage) {
		if (StringUtils.isBlank(count)) {
			throw new IllegalArgumentException("질문에 대한 내용을 입력해주세요.");
		}

		validateNumber(count);
		if (Integer.parseInt(count) <= 0) {
			throw new IllegalArgumentException(exceptionMessage);
		}
	}

	public String getQuestion() {
		return question;
	}

	public void setInit(CarRacingInitValue initValue, String value) {
		this.validate.accept(value);
		this.carRacingInitValueConsumer.accept(initValue, value);
	}
}
