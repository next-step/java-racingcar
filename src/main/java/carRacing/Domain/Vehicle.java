package carRacing.Domain;


public interface Vehicle {
    void move();
    String getName();
    int inquiryPosition();
    int greaterThen(int position);
}
