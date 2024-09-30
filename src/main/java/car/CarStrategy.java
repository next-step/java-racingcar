package car;

public interface CarStrategy {

    //차량 전진 메소드
    void forward();
    //차량 거리 출력 메소드
    void result();
    int getDistance();

}
