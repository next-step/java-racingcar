package game;

import racing.Car;
import racing.MessageBox;

import java.util.*;

public class GamePlay {

    private final List<Player> players;
    private final Validation validation;
    private final Random random;
    private final Utils utils;
    private final HashMap<String,Integer> playingResult;
    private final MessageBox messageBox;
    private final StringBuffer winnerPlayList;

    public GamePlay(MessageBox messageBox) {
        utils = new Utils();
        players = new ArrayList<>();
        validation = new Validation(utils);
        random = new Random();
        playingResult= new HashMap<>();
        this.messageBox = messageBox;
        winnerPlayList = new StringBuffer();
    }

    public List<Player> createPlayer(String playerListValue) {
        String[] playerArray = utils.stringToStringArray(playerListValue);
        validation.validStringEmpty(utils.stringByTrim(playerListValue));
        winnerPlayList.setLength(playerArray.length);
        return setupPlayer(playerArray);
    }

    public List<Player> setupPlayer(String[] playerArray) {
        int CHECK_LENGTH = 4;
        for (String playerName : playerArray) {
            validation.validStringLength(playerName, CHECK_LENGTH);
            Player player = new Player(playerName);
            players.add(player);
        }
        return players;
    }

    public void playingGame(String inputValue) {
        validation.validNUmberChecK(inputValue);
        int tryGameCount = utils.stringToInt(inputValue);
        messageBox.commonMessageBox("실행 결과");
        for (int i = 0; i < tryGameCount; i++) {
            gamePlay();
        }
    }

    private void gamePlay() {
        for (Player player : players) {
            int resultRacing = player.playToMove(randomValue());
            playingResult.put(player.getPlayerName(),resultRacing);
            messageBox.racingResultMessage(resultRacing);
        }
        messageBox.commonMessageBox("");
    }

    public int randomValue() {
        int RANDOM_VALUE = 10;
        return random.nextInt(RANDOM_VALUE);
    }

    public String winnerPlayer() {
        for (Map.Entry<String, Integer> entry : playingResult.entrySet()) {
            winnerPlayList.append(searchWinner(entry.getKey(),entry.getValue()));
        }
        return utils.stringBufferToString(winnerPlayList);
    }

    private String searchWinner(String playerName, int checkValue) {
        return checkValue == utils.MapInMaxValue(playingResult.values()) ? playerName : "";
    }
    
}

