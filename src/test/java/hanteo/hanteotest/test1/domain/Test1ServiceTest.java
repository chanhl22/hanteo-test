package hanteo.hanteotest.test1.domain;

import hanteo.hanteotest.test1.utils.DataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Test1ServiceTest {

    @DisplayName("성별로 게시판을 검색해서 찾은 결과를 JSON 텍스트로 조회한다.")
    @Test
    void findGender() {
        //given
        Test1Service test1Service = new Test1Service(
                new DataGenerator());

        String categoryIndex = "성별";
        String categoryName = "남자";

        //when
        String text = test1Service.find(categoryIndex, categoryName);

        //then
        assertThat(text).isEqualTo("{\"gender\":\"MAN\",\"groups\":[{\"id\":1,\"groupName\":\"엑소\",\"boards\":[{\"id\":1,\"boardName\":\"공지사항\"},{\"id\":2,\"boardName\":\"첸\"},{\"id\":3,\"boardName\":\"백현\"},{\"id\":4,\"boardName\":\"시우민\"}]},{\"id\":2,\"groupName\":\"방탄소년단\",\"boards\":[{\"id\":5,\"boardName\":\"공지사항\"},{\"id\":6,\"boardName\":\"익명게시판\"},{\"id\":7,\"boardName\":\"뷔\"}]}]}");
    }

    @DisplayName("그룹으로 게시판을 검색해서 찾은 결과를 JSON 텍스트로 조회한다.")
    @Test
    void findGroup() {
        //given
        Test1Service test1Service = new Test1Service(
                new DataGenerator());

        String categoryIndex = "그룹";
        String categoryName = "엑소";

        //when
        String text = test1Service.find(categoryIndex, categoryName);

        //then
        assertThat(text).isEqualTo("{\"id\":1,\"groupName\":\"엑소\",\"boards\":[{\"id\":1,\"boardName\":\"공지사항\"},{\"id\":2,\"boardName\":\"첸\"},{\"id\":3,\"boardName\":\"백현\"},{\"id\":4,\"boardName\":\"시우민\"}]}");
    }

    @DisplayName("게시판을 검색해서 찾은 결과를 JSON 텍스트로 조회한다.")
    @Test
    void findBoard() {
        //given
        Test1Service test1Service = new Test1Service(
                new DataGenerator());

        String categoryIndex = "게시판";
        String categoryName = "첸";

        //when
        String text = test1Service.find(categoryIndex, categoryName);

        //then
        assertThat(text).isEqualTo("[{\"id\":2,\"boardName\":\"첸\"}]");
    }

    @DisplayName("올바른 카테고리 식별자가 아닌 경우 메시지를 JSON 텍스트로 조회한다.")
    @Test
    void noCategoryIndex() {
        //given
        Test1Service test1Service = new Test1Service(
                new DataGenerator());

        String categoryIndex = "잘못됨";
        String categoryName = "";

        //when //then
        assertThatThrownBy(() -> test1Service.find(categoryIndex, categoryName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력한 검색어를 다시 확인해주세요.");
    }

}