package step3;

public class Runner {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputNumberOfCars();

        System.out.println(inputView.numberOfCars());
    }

}
