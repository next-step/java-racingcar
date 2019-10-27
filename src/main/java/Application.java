import step2.Car;
import step2.InputView;

public class Application {
    public static void main(String[] args){
        InputView inputView = new InputView();
        Car[] cars = inputView.input();
    }
}
