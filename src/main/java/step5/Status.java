package step5;

import java.util.Objects;

public class Status {

    private int status;

    public Status(int status) {
        if (status < 0) {
            throw new IllegalArgumentException();
        }
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void increase() {
        status++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return status == status1.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
