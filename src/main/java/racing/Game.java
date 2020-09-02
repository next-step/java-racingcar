package racing;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.carNumberInputView();
        Cars cars = new Cars(inputView.inputValue());
        inputView.tryCountInputView();
        cars.resultViewPrint(inputView.inputValue());
    }
}
