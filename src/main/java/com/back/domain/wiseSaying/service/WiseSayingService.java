package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import com.back.AppContext;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository = AppContext.wiseSayingRepository;

    public WiseSaying register(String content, String author) {
        return wiseSayingRepository.register(content, author);
    }

    public void list() {
        for (WiseSaying wiseSaying : wiseSayingRepository.findAll()) {
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor());
        }
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void delete(int id) {
        WiseSaying wiseSaying = wiseSayingRepository.findById(id);
        if (wiseSaying != null) {
            wiseSayingRepository.delete(wiseSaying);
        }
    }

    public void modify(int id, String content, String author) {
        WiseSaying wiseSaying = wiseSayingRepository.findById(id);
        if (wiseSaying != null) {
            wiseSaying.setContent(content);
            wiseSaying.setAuthor(author);
        }
    }
}
