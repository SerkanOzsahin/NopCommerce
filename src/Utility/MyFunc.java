package Utility;

public class MyFunc {

    public static void Wait(int sn) {

        try {
            Thread.sleep(sn * 1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int randomGenerator(int sinir) {

        return (int) (Math.random() * sinir);
    }
}
