package com.back.domain.wiseSaying.controller;

import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayingService = new WiseSayingService();
    }

    public void register() {
        System.out.println("명언을 입력하세요: ");
        String content = sc.nextLine();
        System.out.println("작가를 입력하세요: ");
        String author = sc.nextLine();
        wiseSayingService.register(content, author);

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("=== 명언 명록 ===");
        wiseSayingService.list();
    }

    public void delete() {
        try {
            String idStr = cmd.substring("삭제?id=".length()).trim();
            int id = Integer.parseInt(idStr);
            WiseSaying wiseSaying = wiseSayingService.findById(id);
            if (wiseSaying == null) {
                System.out.println(id + " 번 명언이 존재하지 않습니다.");
                return;
            }

            wiseSayingService.delete(id);
            System.out.println(id + " 번 명언이 삭제 되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("id는 숫자여야합니다." + e.getMessage());

        }
    }

}
