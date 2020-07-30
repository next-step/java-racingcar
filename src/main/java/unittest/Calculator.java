package unittest;

public interface Calculator {

    public String readInput();
    public String[] splitInput(String input) throws IllegalArgumentException;
    public void validate(String[] inputArr) throws IllegalArgumentException;
    public void calutate(String[] inputArr);
    public int add(int a, int b);
    public int substract(int a, int b);
    public int multiply(int a, int b);
    public int divide(int a, int b);



}
