public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType fromSymbol(char symbol) {
        for(OperatorType o : OperatorType.values()) {
            if(o.symbol == symbol) {
                return o;
            }
        }
        throw new IllegalArgumentException("잘못된 연산 기호입니다. ");
    }
}
