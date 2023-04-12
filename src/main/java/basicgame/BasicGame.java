package basicgame;


public class BasicGame {

    public static void main(String args[]) {

        InputView.printCarInput();
        var carCount = InputView.countInput();

        InputView.printTryInput();
        var tryCount = InputView.countInput();

        CarGroup.startGame(carCount, tryCount);
    }
}
