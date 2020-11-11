package racing.model;

public interface Car {
    void move(int fuel);

    int currentLocation();

    String getCarName();
}
