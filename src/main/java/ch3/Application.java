package ch3;

public class Application {

        public static void main(String[] args)  {
            CarRacing carRacing = new CarRacing(new InputView(), new ResultView());
            carRacing.startGame();
        }
}