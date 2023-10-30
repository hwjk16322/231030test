package org.example.system.systemService;

public class SystemController {
    public void close() {
        System.out.println("앱을 종료합니다..");
    }

    public void loginError(String command){
        System.out.println("로그인해야 " +command + "할 수 있습니다.");
    }
}
