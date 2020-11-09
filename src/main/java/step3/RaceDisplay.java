package step3;

public interface RaceDisplay {

    void writeMovingDistance(String name, int movingDistance);

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
            public void writeBlankLine() {
                System.out.println("");
            }
        };
    }
}


