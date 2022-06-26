package components.enums;

import lombok.Getter;

public enum Status {
    INSTOCK(1),
    LACK(2),
    UTILIZATION(3),
    UTILIZED(4);


    @Getter
    private int status;

    private Status(int status){
        this.status = status;
    }
}
