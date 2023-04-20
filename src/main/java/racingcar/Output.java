package racingcar;

interface Output {

    void printPosition(CarDto carDto);

    void printExecutionHeader();

    void printBlankLine();

    void printPositions(Race race);

    void printWinner(Race race);
}
