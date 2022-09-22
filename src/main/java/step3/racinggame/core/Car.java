package step3.racinggame.core;

public class Car {

    private int position;

    public Car() {
        position = 0;
    }

    public int whereAmI() {
        return position;
    }

    public void move(int fuel) {
        position += assureDistance(fuel);
    }

    private int assureDistance(int fuel) {
        if (fuel >= 4) {
            return 1;
        }
        return 0;
        // 궁금증! else 가 안된다면 삼항연산자도 안되는걸까요? 한줄에 깔끔하게 쓸 때 선호했는데ㅜㅜ
    }

}
