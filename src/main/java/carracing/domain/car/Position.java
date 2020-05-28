package carracing.domain.car;

public class Position {

    private int location = 0;

    public int getLocation() {
        return location;
    }

    public void move(int moveValue) {
        this.setLocation(this.location + moveValue);
    }

    private void setLocation(int location) {
        this.location = location;
    }

    public boolean validate() {
        return this.location < 0;
    }




}
