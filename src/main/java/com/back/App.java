package com.back;

import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private WiseSayingController controller = new WiseSayingController();

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("등록")) {
                controller.register();
            } else if (cmd.equals("목록")) {
                controller.list();
            } else if (cmd.startsWith("삭제")) {
                controller.delete();
            } else if (cmd.startsWith("수정")) {
                controller.update();
            } else if (cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("지원하지 않는 명령입니다.");
            }
        }
        sc.close();
    }
}
