import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {

    private List<Double> results = new ArrayList<>();

    public double calculate(T num1, T num2, char operatorSymbol) {
        OperatorType operatorType = OperatorType.fromSymbol(operatorSymbol);

        double number1 = num1.doubleValue();
        double number2 = num2.doubleValue();

        double result = 0;

        switch (operatorType) {
            case ADD:
                result = number1 + number2;
                break;

            case SUBTRACT:
                result = number1 - number2;
                break;

            case MULTIPLY:
                result = number1 * number2;
                break;

            case DIVIDE:
                if (number2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                }
                result = number1 / number2;
                break;
        }
        result = number1 / number2;
        return result;
    }

}
