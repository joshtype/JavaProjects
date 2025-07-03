//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // weather implements Runnable & run()
        Weather weatherProcess = new Weather();

        // pass to new thread so process can run() in a new thread
        Thread t1 = new Thread(weatherProcess);
        t1.start();  // start thread
    }
}