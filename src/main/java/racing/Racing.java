package racing;

public class Racing {

    private Racing() {
        throw new AssertionError();
    }

    public static Cars startRacing(int carCount, int moveCount) {
        if (carCount <= 0 || moveCount <= 0) {
            throw new IllegalArgumentException("입력값으로 0이나 음수를 넣을 수 없습니다.");
        }
        return Cars.initCars(carCount);
    }

    public static Cars racing(Cars cars) {
        cars.moveCars();
        return cars;
    }
}
