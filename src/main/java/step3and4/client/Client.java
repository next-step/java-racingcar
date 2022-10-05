package step3and4.client;

import step3and4.client.input.ConsoleInputView;
import step3and4.client.number.RandomNumber;
import step3and4.client.output.ConsoleOutputView;
import step3and4.game.CarGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        CarGame carGame = new CarGame(new RandomNumber(), new ConsoleInputView(), new ConsoleOutputView());
        carGame.run();
        BUFFERED_READER.close();
    }

}

