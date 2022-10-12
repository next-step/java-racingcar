package step5.domain;

public class Location {

    private int location;

    public Location(){
        this.location = 0;
    }

    public void move() {
        this.location++;
    }

    public int getLocation() {
        return location;
    }
}
