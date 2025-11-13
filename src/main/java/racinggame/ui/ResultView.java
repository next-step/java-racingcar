package racinggame.ui;

public class ResultView {

    public static void printCarNamesQuestion() {
        String question = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)?";
        System.out.println(question);
    }

    // 위 주석 질문과 동일합니다. 기존이름 : askCarCountToUser
    public static void printTryCountQuestion() {
        String question = "시도할 회수는 몇 회 인가요?";
        System.out.println(question);
    }

    public static void printCarPositionTitle() {
        String question = "실행결과";
        System.out.println(question);
    }

    public static void printCarPosition(String positionMark) {
        System.out.println(positionMark);
    }

    public static void printLineBreaker() {
        System.out.println();
    }
}
