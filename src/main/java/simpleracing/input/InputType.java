package simpleracing.input;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InputType {
	CAR_COUNT("자동차 대수는 몇 대 인가요?",
			  count -> validateCount(count, "자동차 대수는 0대 이하일 수 없습니다."),
			  (initValue, carCount) -> initValue.setCarCount(Integer.parseInt(carCount)),
			  Boolean.FALSE, 2),
	GAME_COUNT("시도할 회수는 몇 회 인가요?",
			   count -> validateCount(count, "시도할 회수는 0회 이하일 수 없습니다."),
			   (initValue, gameCount) -> initValue.setTryCount(Integer.parseInt(gameCount)),
			   Boolean.TRUE, 1),
	CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
			 names -> validateNames(names, "자동차의 이름을 규칙에 맞게 입력해주세요.(예 : pobi,crong,honux"),
			 (initValue, namesString) -> initValue.setNames(namesStringToList(namesString)),
			 Boolean.TRUE, 0);

	private static List<String> namesStringToList(String namesString) {
		return Stream.of(namesString.split(","))
					 .collect(toList());
	}

	static {
		String numberPattern = "^[-+]?(0|[1-9][0-9]*)(\\\\.[0-9]+)?([eE][-+]?[0-9]+)?$";
		pattern = Pattern.compile(numberPattern);
	}

	private final static Pattern pattern;
	private final String question;
	private final Consumer<String> validate;
	private final BiConsumer<CarRacingInitValue, String> carRacingInitValueConsumer;
	private final boolean use;
	private final int order;


	private static void validateNumber(String value) {
		Matcher matcher = pattern.matcher(value);
		boolean number = matcher.matches();

		if (!number) {
			throw new IllegalArgumentException("숫자로 입력해주세요.");
		}
	}

	private static void validateEmpty(String value) {
		if (StringUtils.isBlank(value)) {
			throw new IllegalArgumentException("질문에 대한 내용을 입력해주세요.");
		}
	}


	private static void validateCount(String count, String exceptionMessage) {
		validateEmpty(count);

		validateNumber(count);
		if (Integer.parseInt(count) <= 0) {
			throw new IllegalArgumentException(exceptionMessage);
		}
	}

	private static void validateNames(String namesString, String exceptionMessage) {
		validateEmpty(namesString);

		String[] namesArray = namesString.split(",");
		if (namesArray == null || namesArray.length == 0) {
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

	public static List<InputType> getUsableInputType() {
		return Stream.of(values())
					 .filter(inputType -> inputType.use)
					 .sorted(Comparator.comparingInt(inputType -> inputType.order))
					 .collect(toList());
	}
}
