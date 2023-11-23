package step4.racing.inout;

import step4.racing.Distance;
import step4.racing.Name;

public class OutPutView {

    public void printStatus(Name name , Distance distance) {
        name.print(this);
        this.printSeparator();
        distance.print(this);

    }

    public void printName(String name) {
        System.out.print(name);
    }

    private void printSeparator(){
        System.out.print(" : ");
    }

    public void printDistance(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }

    public void printCommas(boolean printOrNot) {
        if (printOrNot) {
            System.out.print(", ");
        }
    }
    public void printWinnerMessage() {
        System.out.println("가 최종 우승했습니다.");
    }
    public void printGongBack() {
        System.out.println();
    }
}
