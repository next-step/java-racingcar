package racing_car.domain;

import racing_car.common.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class RacingSpec {

    private List<String> users;
    private final Integer lab;

    public RacingSpec(List<String> users, int lab) {
        if (users == null || users.isEmpty() || lab <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RACING_SPEC);
        }
        this.lab = lab;
        this.users = Collections.unmodifiableList(users);
    }

    public Integer getLab() {
        return this.lab;
    }

    public List<String> getUsers() {
        return this.users;
    }
}
