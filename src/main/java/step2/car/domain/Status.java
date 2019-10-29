package step2.car.domain;

public class Status {

    private String name;
    private Integer position = 0;

    public Status(String name) {
        this.name = name;
    }

    private Status(Status status) {
        this.name = status.getName();
        this.position = status.getPosition();
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public Status cloneNow() {
        return new Status(this);
    }

    public void forward() {
        this.position++;
    }

}
