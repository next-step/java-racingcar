package step3;

public class Car {
    private Integer location=0;
    private final String INDEX = "-";

    void moveForward(){
        this.location++;
    }

    @Override
    public String toString() {
        return INDEX.repeat(location);
    }
}
