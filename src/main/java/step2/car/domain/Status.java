package step2.car.domain;

public class Status {
    private static final int START_POSITION = 0;

    private final String name;
    private Integer position = START_POSITION;

    public Status(String name) {
        this.name = name;
    }

    public Status(Status status) {
        this(status.getName());
        this.position = status.getPosition();
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void forward() {
        this.position++;
    }

}
