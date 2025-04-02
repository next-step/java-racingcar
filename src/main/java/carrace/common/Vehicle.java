package carrace.common;

public interface Vehicle {
    String identifier();

    void move(int randomVal);

    String getCurrentPosition();

    String getCarName();
}
