package step3;

public interface RaceDisplay {

    void writeLine(String line);

    void writeBlankLine();

    static RaceDisplay console() {
        return new RaceDisplay() {

            @Override
            public void writeBlankLine() {
                System.out.println("");
            }

            @Override
            public void writeLine(String line) {
                System.out.println(line);
            }
        };
    }


}


