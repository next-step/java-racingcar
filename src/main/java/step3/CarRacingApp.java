package step3;

import step3.controller.CarRacing;

import java.io.IOException;

public class CarRacingApp {
    
    public static void main(String[] args) throws IOException {
        CarRacing carRacing = new CarRacing();
        carRacing.startGame();
    }
}
