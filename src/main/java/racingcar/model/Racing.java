package racingcar.model;

public class Racing {

    public static void game(int attempt) {
        for (Car car : Garage.cars) {
            for (int i = 0; i < attempt; i++) {
                car.move();
            }
        }
    }
}
