package hanteo.hanteotest.test2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Test2ServiceTest {

    @DisplayName("합계를 만드는 방법의 수를 찾는다.")
    @Test
    void solution1() {
        //given
        Test2Service test2Service = new Test2Service();
        int sum1 = 4;
        List<Integer> coins1 = List.of(1, 2, 3);
        int sum2 = 10;
        List<Integer> coins2 = List.of(2,5,3,6);

        //when
        int solution1 = test2Service.solution(sum1, coins1);
        int solution2 = test2Service.solution(sum2, coins2);

        //then
        assertThat(solution1).isEqualTo(4);
        assertThat(solution2).isEqualTo(5);
    }

}