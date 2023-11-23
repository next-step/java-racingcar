package step3;

public class Car {
    private int distance = 1 ; // 현재 차량의 이동 거리

    private Car() {

    }

    public static Car create() {
        return new Car();
    }

    public void move() {
        distance ++;
    }

    public void result(OutPutView outPutView) {
        outPutView.print(this.distance);
    }

}

