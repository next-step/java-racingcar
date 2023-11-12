package controller;

import domain.CarRacing;
import view.InputView;
import view.ResultView;

public class Application {

        public static void main(String[] args)  {
            CarRacing carRacing = new CarRacing(new InputView(), new ResultView());
            carRacing.startGame();
        }
}