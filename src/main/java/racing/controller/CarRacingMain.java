package racing.controller;

import java.util.Scanner;

import racing.view.MessageBox;
import racing.domain.Racing;

public class CarRacingMain {

	public static void main(String[] args) {
		MessageBox messageBox = new MessageBox();
		Racing racing = new Racing(messageBox);
		Scanner scanner = new Scanner(System.in);

		messageBox.firstRequestMessage();
		racing.createPlayer(scanner.next());

		messageBox.secondRequestMessage();
		racing.playingGame(scanner.next());

		scanner.close();
	}

}
