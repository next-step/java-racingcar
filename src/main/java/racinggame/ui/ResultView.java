package racinggame.ui;

public class ResultView {

    // 원래 네이밍은 "askCarCountToUser"입니다. 추상화 레벨로 생각했을때 어떤기능을 하는지 순수하게 네이밍하는게 좋다고 생각했습니다.
    // 왼쪽 네이밍과 아래 네이밍중 어느쪽이 더 적절한지 그 이유는 무엇인지 궁금합니다
    public static void printCarCountQuestion() {
        String question = "자동차 대수는 몇 대 인가요?";
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
