import java.util.List;

public class App {


    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.showInput();

        List<List<Integer>> results = RacingGame.start(inputView.getCar(), inputView.getStage());

        ResultView.print(results);

    }
}

