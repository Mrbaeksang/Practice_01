// src/test/java/com/back/wiseSaying/service/WiseSayingServiceTest.java

package com.back.wiseSaying.service;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;
import com.back.domain.wiseSaying.service.WiseSayingService;
import com.back.domain.wiseSaying.entity.WiseSaying;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WiseSayingServiceTest {

    @Test
    void t1() {
        WiseSayingService service = new WiseSayingService();

        WiseSaying wiseSaying = service.register("행동이 운명을 만든다", "존 듀이");

        assertNotNull(wiseSaying);
        assertEquals("행동이 운명을 만든다", wiseSaying.getContent());
        assertEquals("존 듀이", wiseSaying.getAuthor());
        assertTrue(wiseSaying.getId() > 0);
    }

    @Test
    void t2() {
        WiseSayingService service = new WiseSayingService();
        service.register("행동이 운명을 만든다", "존 듀이");
        service.register("과거에 집착하지 마라", "작자미상");

        List<WiseSaying> result = service.findForList("author", "작자", 1);

        assertThat(result).hasSize(1); // 결과 개수 검증
        assertThat(result.get(0).getAuthor()).isEqualTo("작자미상"); // 내용 검증
    }

    @Test
    @DisplayName("keywordType이 content이고 keyword가 '행동'이면 명언 내용에 해당 단어가 포함된 것만 반환된다")
    void t3() {
        WiseSayingService service = new WiseSayingService();

        service.register("행동이 운명을 만든다", "존 듀이");
        service.register("과거에 집착하지 마라", "작자미상");

        List<WiseSaying> result = service.findForList("content", "행동", 1);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getContent()).contains("행동");
    }

    @Test
    @DisplayName("keywordType이 author일 때, 작가 이름에만 '작자'가 들어간 명언만 필터링된다")
    void t4() {
        WiseSayingService service = new WiseSayingService();

        // 작자: content에만 포함
        service.register("작자는 운명을 바꾼다", "김삿갓");

        // 작자: author에 포함 (이게 정답 데이터)
        service.register("사랑은 모든 것을 이긴다", "작자미상");

        
        List<WiseSaying> result = service.findForList("author", "작자", 1);


        assertThat(result).hasSize(1);
        assertThat(result.get(0).getAuthor()).isEqualTo("작자미상");
    }

    @Test
    @DisplayName("page=1 이면 최신순으로 1~5개 출력된다")
    void t5() {
        WiseSayingService service = new WiseSayingService();

        for (int i = 1; i <= 10; i++) {
            service.register("명언 " + i, "작자미상 " + i);
        }

        List<WiseSaying> result = service.findForList("", "", 1);

        assertThat(result).hasSize(5);
        assertThat(result.get(0).getContent()).isEqualTo("명언 10");
        assertThat(result.get(4).getContent()).isEqualTo("명언 6");
    }





}

