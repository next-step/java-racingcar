package racinggame.domain;

import java.util.List;

public class CommaPatternNames implements Names {

    private final List<String> names;

    public CommaPatternNames(String names) {
        if (names == null) {
            throw new NullPointerException("이름은 null일 수 없습니다.");
        }
        this.names = toList(splitNames(names));
    }

    @Override
    public List<String> split() {
        return names;
    }

    private String[] splitNames(String names) {
        return names.split(",");
    }

    private List<String> toList(String[] names) {
        return List.of(names);
    }
}
