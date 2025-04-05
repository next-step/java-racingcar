package carrace.vehicle;

public interface Vehicle {
    String identifier();

    void move(int randomValue);

    int getCurrentPosition();

    String getCarName();
}
