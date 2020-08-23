package step3.car;

import step3.command.Command;

import java.util.List;

import static step3.command.Command.GO;

public class Car {

    private List<Command> commandList;

    private Car(){};

    public static Car createCar() {
        return new Car();
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    public int getCarProgress(int currentLocation) {
        int currentProgress = 0;

        for (int i = 0; i <= currentLocation; i++) {
            if (this.commandList.get(i).equals(GO)) {
                currentProgress++;
            }
        }

        return currentProgress;
    }
}


