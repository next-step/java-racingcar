package step5.view;

import step5.domain.Name;
import step5.domain.Position;
import step5.domain.RacingRecord;
import step5.domain.RacingRecords;

import java.util.List;

public class ResultView {

    public static void showRecords(List<RacingRecords> records){
        records.forEach(record -> showRecord(record));
    }

    public static void showRecord(RacingRecords moveRecords) {
        moveRecords.getRacingRecords().forEach(moveResult -> showResult(moveResult));
        System.out.println();
    }

    private static void showResult(RacingRecord moveRecord) {

        ResultViewTemplate resultViewTemplate = (_name, _position) -> {

            final String PROCESS_BAR = "-";
            final String DELIMITER = " : ";

            StringBuilder resultExpression = new StringBuilder(_name);
            resultExpression.append(DELIMITER);
            for(int i = 0 ; i < _position ; i++){
                resultExpression.append(PROCESS_BAR);
            }
            System.out.println(resultExpression);
        };

        String carName = moveRecord.getCarName();
        int position = moveRecord.getPosition();

        resultViewTemplate.show(carName, position);
    }

    public static void infoWinners(List<String> winners) {

        String winnerMessage = "";
        String winnerDelimiter = ", ";

        for(String winner : winners){
            winnerMessage += winner;
            winnerMessage += winnerDelimiter;
        }
        winnerMessage = winnerMessage.substring(0, winnerMessage.lastIndexOf(winnerDelimiter));
        winnerMessage += "가 최종 우승했습니다.";

        System.out.println(winnerMessage);
    }
}

