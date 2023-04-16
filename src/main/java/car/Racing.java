package car;

import car.Impl.MoveRandem;

public class Racing {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = inputView.inputValue();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int frequency = inputView.inputValue();
    }







}
