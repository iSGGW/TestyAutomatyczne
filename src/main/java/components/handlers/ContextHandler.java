package components.handlers;

import components.enums.Context;
import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;

import static configuration.Utils.delay;

public class ContextHandler {
    private AppiumDriver driver;

    public ContextHandler(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public boolean switchToWebContext(){
        ArrayList<String> contexts = new ArrayList<>(driver.getContextHandles());
        int retry = 0;
        while(retry < 10){
            for(String contex : contexts){
                if(contex.contains(Context.WEB.getContext())){
                    System.out.println("Switching to WEB context");
                    driver.context(Context.WEB.getContext());
                    System.out.println("DONE");
                    return true;
                }else{
                    System.out.println("Retry searching for WEBVIEW ...");
                    delay(2000);
                }
                retry++;
            }
        }
        return false;
    }

    public boolean switchToNativeContext(){
        ArrayList<String> contexts = new ArrayList<>(driver.getContextHandles());
        int retry = 0;
        while(retry < 10){
            for(String contex : contexts){
                if(contex.contains(Context.NATIVE.getContext())){
                    System.out.println("Switching to Native context");
                    driver.context(Context.NATIVE.getContext());
                    System.out.println("DONE");
                    return true;
                }else{
                    System.out.println("Retry searching for Native context ...");

                }
                retry++;
            }
        }
        return false;
    }
}
