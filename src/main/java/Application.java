import step2.InputView;
import step2.Racing;

public class Application {
    public static void main(String[] args){
        InputView inputView = new InputView();
        inputView.input();
        Racing racing = new Racing(inputView);

    }
}
