package game;

public class Car {

    private int location;
    public int location() {
        return location;
    }

    public void changeLocation(int given) {
        if(isForward(given)){
            location+=1;
        }
    }

    private static boolean isForward(int given) {
        return given >= 4;
    }
}
