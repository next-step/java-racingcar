package racingcar.model;

import java.util.UUID;

public class Identity {
    private String id;

    public Identity() {
        this.id = UUID.randomUUID().toString();
    }
}
