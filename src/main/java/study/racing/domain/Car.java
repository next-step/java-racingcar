package study.racing.domain;

public class Car {

    private static final String MARK = "-";

    private String name;
    private String position;

    public Car(String name) {
        this.name = name;
        this.position = "";
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void forwardPosition(){
        this.position += MARK;
    }

}
