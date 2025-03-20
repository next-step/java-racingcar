package domain;

public class RacingCarCurrentStatus {
    private final String name;
    private final Integer position;

    protected RacingCarCurrentStatus(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String whatNameIsThisCar() {
        return this.name;
    }

    public Integer whereIsThisCarNow() {
        return this.position;
    }
}
