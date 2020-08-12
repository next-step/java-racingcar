package racing;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.getCarNumber());
        cars.resultViewPrint(inputView.getTryCount());
    }
}
