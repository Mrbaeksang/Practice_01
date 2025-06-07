package com.back.domain.wiseSaying.controller;

import com.back.AppContext;
import com.back.Rq;
import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc = AppContext.scanner;
    private final WiseSayingService wiseSayingService = AppContext.wiseSayingService;

    public void register() {
        System.out.println("명언을 입력하세요: ");
        String content = sc.nextLine();
        System.out.println("작가를 입력하세요: ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.register(content, author);

        System.out.println(wiseSaying);

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("=== 명언 명록 ===");
        wiseSayingService.list();
    }

    public void delete(Rq rq) {
        int id = rq.getParamAsInt("id", -1);
        if(id == -1) {
            System.out.println("삭제할 번호를 제대로 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);
        if (wiseSaying == null) {
            System.out.println(id+"번 명언이 존재하지 않습니다.");
            return;
        }

        wiseSayingService.delete(id);

        System.out.println(id+"번 명언이 삭제되었습니다.");
    }

    public void modify(Rq rq) {
       int id = rq.getParamAsInt("id", -1);
       if(id == -1) {
           System.out.println("수정할 번호를 제대로 입력해주세요.");
       }

       WiseSaying wiseSaying = wiseSayingService.findById(id);
       if (wiseSaying == null) {
           System.out.println(id+"번 명언이 존재하지 않습니다.");
       }

       System.out.println("명언을 입력해주세요: ");
       String content = sc.nextLine();
       System.out.println("작가를 입력해주세요: ");
       String author = sc.nextLine();

       wiseSayingService.modify(id, content, author);

       System.out.println(id+"번 명언이 수정된 일이 완료되었습니다.");
    }

}
