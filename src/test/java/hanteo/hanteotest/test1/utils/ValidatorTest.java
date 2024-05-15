package hanteo.hanteotest.test1.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("입력한 검색 키워드의 길이가 부족하면 예외가 발생한다.")
    @Test
    void checkLength() {
        //given
        Validator validator = new Validator();
        List<String> input = List.of("없음");


        //when //then
        assertThatThrownBy(() -> validator.validateSearch(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력한 검색어를 다시 확인해주세요.");
    }

    @DisplayName("입력한 검색 카테고리가 정해진 키워드와 다르면 예외가 발생한다.")
    @Test
    void checkCategory() {
        //given
        Validator validator = new Validator();
        List<String> input = List.of("없음", "없음");


        //when //then
        assertThatThrownBy(() -> validator.validateSearch(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력한 카테고리를 다시 확인해주세요.");
    }

    @DisplayName("입력한 검색 성별이 남자 또는 여자가 아니면 예외가 발생한다.")
    @Test
    void checkGender() {
        //given
        Validator validator = new Validator();
        List<String> input = List.of("성별", "없음");


        //when //then
        assertThatThrownBy(() -> validator.validateSearch(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 성별은 남자 또는 여자만 입력해주세요.");
    }

}