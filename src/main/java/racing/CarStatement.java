package racing;

public class CarStatement {
    private final String name;
    private int position;

    public CarStatement(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        position += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int max(int max) {
        if (position > max) {
            return position;
        }

        return max;
    }
}
