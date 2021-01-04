import task1.Task1Controller;
import task2.Task2Controller;

public class Main {
    public static void main(String[] args) {
        //task1
        Task1Controller task1Controller = new Task1Controller();
        task1Controller.run();

        //task2
        String input = "pdf the a text 1";
        System.out.println("input is '" + input + "'\n");

        Task2Controller contr = new Task2Controller(input);
        contr.start();

    }
}
