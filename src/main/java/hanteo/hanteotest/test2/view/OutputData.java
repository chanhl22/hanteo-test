package hanteo.hanteotest.test2.view;

public class OutputData {

    private static final String INPUT_SUM_MESSAGE = "정수의 합계를 입력해주세요.";
    private static final String INPUT_COINS_MESSAGE = "각 동전의 유형을 입력하세요.(동전은 쉼표(,) 기준으로 구분, 예시 = 1,2,3)";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public static void printSumInputMessage() {
        print(INPUT_SUM_MESSAGE);
    }

    public static void printCoinsInputMessage() {
        print(INPUT_COINS_MESSAGE);
    }

    public static void printResult(int result) {
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

    public static void print(int result) {
        System.out.println(result);
    }

    public static void printNewLine() {
        System.out.println();
    }

}
