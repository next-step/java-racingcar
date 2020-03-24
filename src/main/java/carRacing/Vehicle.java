package carRacing;


public interface Vehicle {
    void move(MoveStrategy moveStrategy);
    int inquiryPosition();
}
