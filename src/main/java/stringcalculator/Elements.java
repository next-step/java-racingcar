package stringcalculator;

import java.util.List;

public class Elements {
    private final List<String> elements;

    public Elements(String[] elements) {
        validate(elements);
        this.elements = List.of(elements);
    }

    private void validate(String[] elements) {
        for (String element : elements) {
            validateNumber(element);
        }
    }

    private void validateNumber(String element) {
        if (!element.matches("^[0-9]*$")) {
            throw new RuntimeException("0이상 9이상의 숫자만 가능합니다");
        }
    }

    public int sum() {
        System.out.println("elements = " + elements);
        if (elements.isEmpty()) {
            return 0;
        }

        return elements.stream()
                .mapToInt(element -> stringToInt(element))
                .sum();
    }

    private int stringToInt(String element) {
        if (element.isBlank()) {
            return 0;
        }
        return Integer.parseInt(element);
    }
}
