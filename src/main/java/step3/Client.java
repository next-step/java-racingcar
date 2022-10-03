package step3;

import step3.game.CarGame;
import step3.input.ConsoleInputView;
import step3.number.RandomNumber;
import step3.output.BarOutputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        CarGame carGame = new CarGame(new RandomNumber(), new ConsoleInputView(), new BarOutputView());
        carGame.run();
        BUFFERED_READER.close();
    }

}

