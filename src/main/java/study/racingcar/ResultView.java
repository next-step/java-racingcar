package study.racingcar;

public class ResultView {

    String questionCarCountMessage = "자동차 대수는 몇 대 인가요?";
    String questionTryCountMessage = "시도할 회수는 몇 회 인가요?";
    String questionNoMessage = "NO MESSAGE";

    public String questionMessage(String type) {
        if (type.equals("TRY")) {
            return questionTryCountMessage;
        } else if (type.equals("CAR")) {
            return questionCarCountMessage;
        }
        return questionNoMessage;
    }
}
