package ThirdStep.controller;

import ThirdStep.domain.model.GameSetting;
import ThirdStep.domain.model.RecordByRound;
import ThirdStep.domain.PlayService;
import ThirdStep.domain.model.request.SettingRequest;
import ThirdStep.view.RecordPrintView;
import ThirdStep.view.UserInputView;

import java.util.List;

public class CarRacingGame {
    public static RecordPrintView recordPrintView = new RecordPrintView();
    public static UserInputView userInputView = new UserInputView();
    public static PlayService playService = new PlayService();

    public static void main(String[] args) {
        SettingRequest settingRequest = userInputView.generateSettingRequest();
        GameSetting gameSetting = new GameSetting(settingRequest);

        List<RecordByRound> record = playService.racing(gameSetting);

        recordPrintView.printRecord(record);
        recordPrintView.announceWinner(record);
    }
}
