package components.enums;

import lombok.Getter;

public enum Context {
    NATIVE("NATIVE_APP"),
    WEB("WEBVIEW_wit.android");

    @Getter
    private String context;

    private Context(String context){
        this.context = context;
    }
}
