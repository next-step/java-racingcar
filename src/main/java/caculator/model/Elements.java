package caculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Elements {

    private final List<Element> elements;

    public Elements(final String[] operands) {
        this.elements = Arrays.stream(operands)
                              .map(Element::new)
                              .collect(Collectors.toList());
    }

    public List<Element> getElements() {
        return elements.stream()
                       .collect(Collectors.toUnmodifiableList());
    }
}
