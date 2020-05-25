package carracing.domain.car;

public class Position {

    private int location = 0;

    public int getLocation() {
        return location;
    }

    public void move(int moveValue) {
        this.setLocation(this.location + moveValue);
    }

    public boolean isAtLocation(int location) {
        return this.location == location;
    }

    private void setLocation(int location) {
        this.location = location;
    }

    public boolean validate() {
        return this.location < 0;
    }




}
