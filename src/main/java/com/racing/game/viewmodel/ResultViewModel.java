package com.racing.game.viewmodel;

import com.racing.game.entity.Circuit;

public class ResultViewModel {

    private final Circuit circuit;

    public ResultViewModel(Circuit circuit){
        this.circuit = circuit;
    }

    public String allResultString(){
        return circuit.toString();
    }

    public String winnersName(){
        return circuit.winners().winnersName();
    }
}
