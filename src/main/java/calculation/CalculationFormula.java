package calculation;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CalculationFormula {
	private static final String NULL_ERROR_MESSAGE = "error : null 값은 사용할수 없습니다.";
	private static final String EMPTY_ERROR_MESSAGE = "error : 공백은 사용할수 없습니다.";
	private static final String INPUT_TYPE_ERROR_MESSAGE = "error : 아라비아 숫자나 사칙연산자 가 아닌 문자가 있습니다.";
	private static final String OPERATOR_PATTERN = "[-/*+]";
	private static final String NUMBER_PATTERN = "^[0-9]*$";
	private static final String EMPTY = " ";
	private final String[] formula;

	public CalculationFormula(String formula) {
		checkNull(formula);
		checkEmpty(formula);
		checkIndexNumber(formula);
		this.formula = emptyDataSplit(formula);
	}

	private void checkNull(String value) {
		if (value == null) {
			throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
		}
	}

	private void checkEmpty(String value) {
		if (value.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
		}
	}

	private void checkIndexNumber(String formula){
		String[] numbers = separateNumber(emptyDataSplit(formula));
		for(int i=0; i<numbers.length; i++){
			checkInputType(numbers[i]);
		}
	}

	private String[] separateNumber(String[] formula) {
		return Arrays.stream(formula)
			.map(String::valueOf)
			.filter(i -> !Pattern.matches(OPERATOR_PATTERN, i))
			.toArray(String[]::new);
	}

	private void checkInputType(String value){
		if(!Pattern.matches(NUMBER_PATTERN, value)){
			throw new IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE);
		}
	}

	private String[] emptyDataSplit(String data) {
		return data.split(EMPTY);
	}

	public String[] getFormula() {
		return formula;
	}
}
