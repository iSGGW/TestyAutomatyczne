package configuration;

public class Utils {

    public static void delay(int milis){
        try{
            Thread.sleep(milis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
