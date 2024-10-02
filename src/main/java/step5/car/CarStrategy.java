package step5.car;

public interface CarStrategy {

    //차량 전진 메소드
    void forward();

    int getDistance();

    String getCarName();

    CarStrategy copy();

}
