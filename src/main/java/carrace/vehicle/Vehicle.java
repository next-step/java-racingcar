package carrace.vehicle;

public interface Vehicle {
    String identifier();

    void move(int randomValue);

    String getCurrentPosition();

    String getCarName();
}
