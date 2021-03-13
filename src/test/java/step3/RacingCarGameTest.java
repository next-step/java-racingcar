package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.StringUtils;

import java.util.Random;

/**
 * TODO : 기능 요구사항
 * 1. 초간단 자동차 경주 게임을 구현한다.
 * 2. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 3. 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 4. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * 5. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 */
class RacingCarGameTest {

  private int totalPlayerCount;
  private int totalRound;

  @BeforeEach
  void setUp() {
    totalPlayerCount = 5;
    totalRound = 3;
  }

  @Test
  void start() {
    String[] players = getPlayers(totalPlayerCount);

    for (int roundNumber = 0; roundNumber < totalRound; roundNumber++) {
      System.out.println(String.format("\n==========round%d start==========", roundNumber + 1));
      for (int playerNumber = 0; playerNumber < totalPlayerCount; playerNumber++) {
        if (isMove()) {
          players[playerNumber] += "=";
        }
        System.out.println(String.format("playerNumber%d : %s", playerNumber + 1, defaultString(players[playerNumber])));
      }
    }
  }

  private String[] getPlayers(int player) {
    String[] players = new String[player];
    for (int i = 0; i < players.length; i++) {
      players[i] = "";
    }
    return players;
  }

  private String defaultString(String str) {
    if (StringUtils.isBlank(str)) {
      return "";
    }
    return str;
  }

  private boolean isMove() {
    return getRandomNumber() >= 4;
  }

  private int getRandomNumber() {
    return new Random().nextInt(10);
  }
}
