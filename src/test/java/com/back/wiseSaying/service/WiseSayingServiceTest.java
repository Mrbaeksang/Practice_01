// src/test/java/com/back/wiseSaying/service/WiseSayingServiceTest.java

package com.back.wiseSaying.service;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;
import com.back.domain.wiseSaying.entity.WiseSaying;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WiseSayingServiceTest {

    @Test
    void 명언이_정상적으로_등록되어야_한다() {
        WiseSayingService service = new WiseSayingService();

        WiseSaying wiseSaying = service.register("행동이 운명을 만든다", "존 듀이");

        assertNotNull(wiseSaying);
        assertEquals("행동이 운명을 만든다", wiseSaying.getContent());
        assertEquals("존 듀이", wiseSaying.getAuthor());
        assertTrue(wiseSaying.getId() > 0);
    }
}
