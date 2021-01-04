import task1.Task1Controller;
import task2.Task2Controller;

public class Main {
    public static void main(String[] args) {

        //task2
        //search bu file.name

        String input = "pdf the a text 1";
        System.out.println("input is '" + input + "'\n");
        //  //
        Task2Controller contr = new Task2Controller(input);
        contr.start();

        // contr.getCount(input);


        //task1
/*
        Task1Controller task1Controller = new Task1Controller();
        task1Controller.run();
*/
        Thread t1=new Thread();
        Thread t2=new Thread();
        Thread t3=new Thread();
        Thread t4=new Thread();

        for(int i=0;i<6;i++){
            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }

    }
}
