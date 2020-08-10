package racingcar;

class ResultView {

    void changeLines() {
        System.out.println();
    }

    void printlnMessage(String message) {
        System.out.println(message);
    }

    void printlnLaps(int laps) {
        String lapMart = "-";
        System.out.println(lapMart.repeat(laps));
    }
}
