package racing;

public class Car {

    private int location = 0;
    protected static final String SYMBOL = "-";

    public int getLocation() {
        return location;
    }

    public void move() {
        location++;
    }

    public String getTrack() {
        if (location == 0) {
            return "";
        }

        return new String(new char[location]).replace("\0", SYMBOL);
    }

}
