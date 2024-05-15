package hanteo.hanteotest.test1.view;

public class OutputData {

    private static final String INPUT_SUM_MESSAGE = """
            검색할 카테고리 식별자 또는 카테고리명을 입력해주세요.(쉼표(,) 기준으로 구분)
             - 예시1 = 성별,남자
             - 예시2 = 그룹,엑소
             - 예시3 = 게시판,첸""";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public static void printSearchInputMessage() {
        print(INPUT_SUM_MESSAGE);
    }

    public static void printResult(String result) {
        printExecutionMessage();
        print(result);
    }

    private static void printExecutionMessage() {
        printNewLine();
        print(EXECUTION_RESULT_MESSAGE);
    }

    public static void print(String result) {
        System.out.println(result);
    }

    public static void printNewLine() {
        System.out.println();
    }

}
