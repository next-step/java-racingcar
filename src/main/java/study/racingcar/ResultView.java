package study.racingcar;

public class ResultView {

    private final String questionCarCountMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String questionTryCountMessage = "시도할 회수는 몇 회 인가요?";
    private final String playResultMessage = "\n실행결과";
    private final String noMessage = "NO MESSAGE";
    private final String carNameErrorMessage = "자동차 이름은 5자 이내여야 합니다. 다시 입력해주세요.";
    private final String raceResultMessage = "가 최종 우승했습니다.";
    private final String locationString = "-";


    public void viewEmpty() {
        System.out.println();
    }

    public String viewQuestionMessage(String type) {
        if (type.equals("TRY")) {
            return questionTryCountMessage;
        } else if (type.equals("CAR")) {
            return questionCarCountMessage;
        } else if (type.equals("PLAY_RESULT")) {
            return playResultMessage;
        } else if (type.equals("NAME_ERROR")) {
            return carNameErrorMessage;
        } else if (type.equals("RACE_RESULT")) {
            return raceResultMessage;
        }
        return noMessage;
    }

    public String concatString(String str1, String str2) {
        String result = "";
        if (!str1.equals("")) {
            result = str1 + ", " + str2;
        } else if (str1.equals("")) {
            return str2;
        }
        return result;
    }

    public String viewLocationMark(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += locationString;
        }
        return result;
    }

    public String viewCarStatus(RacingCar racingCar) {
        return racingCar.getCarName() + " : " + viewLocationMark(racingCar.getForwardCount());
    }


}
