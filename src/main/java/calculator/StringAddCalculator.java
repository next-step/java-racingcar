package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {

	private int sum(List<Positive> positives) {
		return positives.stream()
			.mapToInt(Positive::getNumber)
			.sum();
	}

	private List<Positive> split(InputText text) {
		return text.split();
	}

	public int splitAndSum(String text) {

		InputText inputText = new InputText(text);

		if (inputText.isBlank()) {
			return 0;
		}

		List<Positive> positives = split(inputText);

		return sum(positives);
	}

	class InputText {

		private static final String CUSTOM_DELIMETER_START = "//";
		private static final String CUSTOM_DELIMETER_END = "\n";
		private static final String DEFAULT_DELIMETER_PATTERN = "[,:]";

		private String text;

		private InputText(String text) {
			this.text = text;
		}

		private boolean isBlank() {
			return this.text == null || this.text.isBlank();
		}

		private boolean hasCustomDelimeter() {
			return this.text.startsWith(CUSTOM_DELIMETER_START) && this.text.contains(CUSTOM_DELIMETER_END);
		}

		private String getCustomDelimeter() {
			return this.text.substring(CUSTOM_DELIMETER_START.length(), this.text.indexOf(CUSTOM_DELIMETER_END));
		}

		private String getRemovedCustomDelimterText() {
			return this.text.substring(this.text.indexOf(CUSTOM_DELIMETER_END) + CUSTOM_DELIMETER_END.length());
		}

		private List<Positive> getPositives(String[] splitedStrings) {
			return Arrays.stream(splitedStrings).
				map(Positive::new).
				collect(Collectors.toList());
		}

		private List<Positive> split() {
			if (this.hasCustomDelimeter()) {
				return getPositives(this.getRemovedCustomDelimterText().split(getCustomDelimeter()));
			}

			return getPositives(this.text.split(DEFAULT_DELIMETER_PATTERN));
		}
	}

}
