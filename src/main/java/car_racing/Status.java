package car_racing;

public enum Status {
    MOVE("-"),
    STOP("");

    public String signal;

    Status(String signal) {
        this.signal = signal;
    }
}
