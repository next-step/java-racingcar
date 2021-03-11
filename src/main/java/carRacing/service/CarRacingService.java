package carRacing.service;

import carRacing.dto.UserInput;

import java.util.List;

public class CarRacingService {

    private UIService uiService = new UIService();
    private JudgeService judgeService = new JudgeService();
    private RaceService raceService = new RaceService();

    private UserInput userInput;
    private List<String> scoreboard;

    public void run(){
        userInput = uiService.getUserInput();
        scoreboard = raceService.prepareScoreboard(userInput);
        while(!judgeService.isGameOver(userInput)){
            scoreboard = raceService.updateScoreboard(scoreboard);
            uiService.printScoreboard(scoreboard);
            userInput = judgeService.checkRemainingRace(userInput);
        }
    }
}
