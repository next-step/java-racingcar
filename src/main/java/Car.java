public class Car {
    private Name name;
    private int position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void moveOnCondition(int num) {
        if (isMove(num)) {
            this.position++;
        }
    }

    private boolean isMove(int num) {
        if (num > 3) {
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
