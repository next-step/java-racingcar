package racingcar.step4.domain;

import java.util.List;

public class Names {
    List<String> names;

    public Names(List<String> names) {
        names.forEach(Names::validateName);

        this.names = names;
    }

    public List<String> copyNames() {
        return List.copyOf(names);
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 글자는 5자를 초과할 수 없습니다.");
        }
    }
}
