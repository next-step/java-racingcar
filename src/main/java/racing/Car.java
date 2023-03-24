package racing;

public class Car {
    private static final int FORWARD_NUMBER = 4; //4이상일때 이동
    public final String name;
    private int position;


    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkName(name);

        this.position = position;
        this.name = name;
    }

    private void checkName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차이름은 5글자 미만이여야 합니다.");
        }
    }

    public int move(int moveValue) {
        if (FORWARD_NUMBER <= moveValue) {
            position++;
        }

        return position;
    }

    public String getPositionFormat() {
        return name + " : " + translatePosition(this.position);
    }

    public String translatePosition(int position) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}