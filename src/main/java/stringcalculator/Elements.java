package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Elements {
    private final List<Element> elements;

    public Elements(final String[] values) {
        this.elements = generateElements(values);
    }

    private List<Element> generateElements(final String[] values) {
        return Arrays.stream(values)
                .map(value -> new Element(value))
                .collect(Collectors.toList());
    }

    public int sum() {
        if (elements.isEmpty()) {
            return 0;
        }

        return elements.stream()
                .mapToInt(Element::toInt)
                .sum();
    }
}
