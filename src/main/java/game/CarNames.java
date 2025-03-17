package game;

import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private final List<CarName> names;

    public CarNames(List<CarName> usernames) {
        validate(usernames);
        this.names = usernames;
    }

    private void validate(List<CarName> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차들의 이름이 제공되지 않았습니다.");
        }
    }

    public List<String> names() {
        return this.names.stream()
                .map(CarName::name)
                .collect(Collectors.toList());
    }
}
