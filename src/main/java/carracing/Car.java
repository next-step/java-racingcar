package carracing;

public class Car {
    int distance = 0;

    public int move(int randomNum) {
        if (randomNum >= 4) {
            distance++;
        }
        return distance;
    }
}
