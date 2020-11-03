package study.racingcar.view;

public class CommandLineInputView implements InputView{

    @Override
    public void numberOfCarsMessage() {
        System.out.println("How many cars do you need?");
    }

    @Override
    public void numberOfTriesMessage() {
        System.out.println("How many attempts are you going to make?");
    }
}
