package carracing;

public class Car {
    int distance = 1;

    public int move(int randomNum) {
        if (randomNum >= 4) {
            distance++;
        }
        return distance;
    }
}
