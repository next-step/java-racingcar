package race;

import java.util.concurrent.atomic.AtomicInteger;

public class Car {
    private final AtomicInteger location = new AtomicInteger();

    public synchronized void move() {
        location.incrementAndGet();
    }

    public int location() {
        return location.get();
    }
}
