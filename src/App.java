import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextDouble();

            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextDouble();

            if (num1 < 0 || num2 < 0) {
                System.out.println("양의 정수 또는 양의 실수만 입력할 수 있습니다.");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            try {
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
                System.out.println("저장된 연산 결과: " + calculator.getResults());
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("조회할 기준값을 입력하세요: ");
            double target = sc.nextDouble();

            List<Double> greaterResults = calculator.getResultsGreaterThan(target);
            System.out.println(target + "보다 큰 연산 결과: " + greaterResults);

            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
            String removeAnswer = sc.next();

            if (removeAnswer.equals("remove")) {
                calculator.removeResult();
                System.out.println("삭제 후 저장된 연산 결과: " + calculator.getResults());
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

        sc.close();
    }
}