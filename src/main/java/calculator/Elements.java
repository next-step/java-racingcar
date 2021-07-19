package calculator;

import java.util.Arrays;

public class Elements {

    private final String[] elements;

    public Elements(String[] elements) {
        this.elements = new String[elements.length];

        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            this.elements[i] = element;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Elements)) return false;
        Elements elements1 = (Elements) o;
        return Arrays.equals(elements, elements1.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}
