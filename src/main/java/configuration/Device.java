package configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Device {
    @Getter
    private AppiumDriver driver;
    @Getter
    private boolean isIOS;
    private String udid;

    public Device(){
        System.out.println("Creating device");
    }

    private void setIsIOS() {
        if(driver.getPlatformName().equals("Android")) isIOS = false;
        else isIOS = true;
    }

    public void setDriver(URL url, DesiredCapabilities caps) {
        driver = new AndroidDriver(url, caps);
    }

    public void startApp(){
        driver.activateApp("com.android.chrome");
    }

    public String getUDID(){
        udid = null;
        String command = "adb devices";
        System.out.println("Run command " + command);
        try{
            Process process = Runtime.getRuntime().exec(command);
            int resultCode = process.waitFor();


            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            Pattern pattern = Pattern.compile("(.*?).device");
            String line = "";
            System.out.println("Reading command output");
            while((line = reader.readLine()) != null){
                System.out.println(line);
                if(line.contains("device")){
                    Matcher m = pattern.matcher(line);

                    if(m.find()){
                        System.out.println("Found udid: " + m.group(1));
                        udid = m.group(1);
                    }
                }
            }
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
            System.out.println("Unable to get phone UDID!!!");
        }

        System.out.println("PHONE UDUD - " + udid);
        return udid;
    }
}
