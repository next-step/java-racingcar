package car;

import car.Impl.MoveRandem;

public class Racing {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        Car car = new Car();
        Move move = new MoveRandem();

        System.out.println("자동차 대수는 몇 대 인가요?");
        int[] cars = car.createIntArray(inputView.inputValue());

        System.out.println("시도할 회수는 몇 회 인가요?");
        int frequency = inputView.inputValue();

        for (int i = 0; i < frequency; i++) {
            cars = move.moveState(cars);
            System.out.println();
        }

    }







}
