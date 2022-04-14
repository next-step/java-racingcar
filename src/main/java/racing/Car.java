package racing;

import java.util.UUID;

public class Car {
    private final UUID id;

    public Car() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
