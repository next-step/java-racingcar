public class Car {
    private Name name;
    private int position;

    private boolean isWinner;

    public Car(String name, int position, boolean isWinner) {
        this.name = new Name(name);
        this.position = position;
        this.isWinner = isWinner;
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

    public String getCarName() {
        return name.getName();
    }

    public boolean getIsWinner() {
        return isWinner;
    }
    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
