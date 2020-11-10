package step3;

import java.util.List;

public interface RaceDisplay {

    void writeMovingDistance(String name, int movingDistance);

    void writeRaceWinner(List<String> names);

    void writeBlankLine();

    static RaceDisplay console() {
        return new RaceDisplay() {
            @Override
            public void writeMovingDistance(String name, int movingDistance) {
                StringBuffer sb = new StringBuffer();
                sb.append(name).append('|');
                while (movingDistance-- > 0) {
                    sb.append('-');
                }
                sb.append("\n");
                System.out.print(sb.toString());
            }

            @Override
            public void writeRaceWinner(List<String> names) {
                System.out.print(String.join(",", names) + "가 최종 우승했습니다.");
            }

            @Override
            public void writeBlankLine() {
                System.out.println("");
            }
        };
    }


}


