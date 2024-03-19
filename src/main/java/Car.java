public class Car {
    private int position;

    public Car(int position) {
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
}
