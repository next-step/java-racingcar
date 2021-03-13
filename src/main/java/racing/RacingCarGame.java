package racing;

import utils.StringUtils;

import java.util.Random;


public class RacingCarGame {

  private String[] players;

  private int totalRound;

  private RacingCarGame() {
  }

  public static RacingCarGame ready(int totalPlayer, int totalRound) {
    RacingCarGame racingCarGame = new RacingCarGame();
    racingCarGame.players = new String[totalPlayer];
    racingCarGame.totalRound = totalRound;
    return racingCarGame;
  }

  public void play() {
    for (int round = 0; round < totalRound; round++) {
      System.out.println(String.format("\n==========round%d start==========", round + 1));
      for (int player = 0; player < players.length; player++) {
        String position = getPosition(player);
        System.out.println(String.format("player%d : %s", player + 1, position));
      }
    }
  }


  private String getPosition(int player) {
    String position = StringUtils.defaultString(players[player]);
    if (isMove()) {
      position += "=";
      players[player] = position;
    }
    return position;
  }


  private boolean isMove() {
    return getRandomNumber() >= 4;
  }

  private int getRandomNumber() {
    return new Random().nextInt(10);
  }
}
