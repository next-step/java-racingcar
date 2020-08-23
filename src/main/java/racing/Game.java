package racing;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarResultView carResultView = new CarResultView();

        inputView.carNumberInputView();
        Cars cars = new Cars(inputView.inputValue());
        inputView.tryCountInputView();
        carResultView.resultViewPrint(inputView.inputValue(), cars.carList);
    }
}
