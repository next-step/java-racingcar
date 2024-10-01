package stringaddcalculator.dto;

public class CalculatorDto {
    private String delimiter;
    private String text;

    public CalculatorDto(String delimiter, String text){
        this.delimiter = delimiter;
        this.text = text;
    }

    public String delimiter(){
        return this.delimiter;
    }
    public String text(){
        return this.text;
    }
}
