package RacingCar;

import java.util.Scanner;

class InputView {

    private Scanner scanner = new Scanner(System.in);

    private int car;
    private int stage;

    void showInput() {
        String CAR_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
        String STAGE_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";


        System.out.println(CAR_INPUT_MESSAGE);
        setCar(scanner.nextInt());

        System.out.println(STAGE_INPUT_MESSAGE);
        setStage(scanner.nextInt());
    }

    private void setCar(int car) {
        this.car = car;
    }

    private void setStage(int stage) {
        this.stage = stage;
    }

    public int getCar() {
        return car;
    }

    public int getStage() {
        return stage;
    }
}