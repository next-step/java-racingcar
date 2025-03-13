package view;

import java.util.*;
import java.util.stream.Collectors;

import exception.ViewDataNotFoundException;

public class AbstractView implements View {

    protected final List<Element> elements;
    private Map<String, String> state;

    protected AbstractView(List<Element> elements) { this.elements = elements; }

    public void render() {
        elements.forEach(Element::action);
        state = elements.stream()
            .collect(Collectors.toMap(Element::getName, Element::getValue));
    }

    @Override
    public ViewData toViewData() { // ViewData 변환
        if (state == null) {
            throw new ViewDataNotFoundException();
        }
        return ViewData.of(state);
    }
}
