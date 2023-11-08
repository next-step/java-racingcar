public class Car {
    private int distance = 1 ; // 현재 차량의 이동 거리
    private int howManyTimesTry; // 현재 차량의 남은 전진 시도 횟수

    private Car(int howManyTimesTry) {
        this.howManyTimesTry = howManyTimesTry;
    }

    public static Car create(int howManyTimesTry) {
        return new Car(howManyTimesTry);
    }

    public void move() {
        if (!this.canMove()) {
            return;
        }
        distance ++;
    }
    private boolean canMove() {
        return howManyTimesTry > 0;
    }
}

