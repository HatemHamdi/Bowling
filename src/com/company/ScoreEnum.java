package com.company;

/**
 * @author Hatem Hamdi
 */
public enum ScoreEnum {

    STRIKE('X', 10),
    SPARE('/', 0),
    NINE('9', 9),
    EIGHT('8', 8),
    SEVEN('7', 7),
    SIX('6', 6),
    FIVE('5', 5),
    FOUR('4', 4),
    THREE('3', 3),
    TWO('2', 2),
    ONE('1', 1),
    MISS('-', 0);

    private final char symbol;
    private int value;

    ScoreEnum(char symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public static ScoreEnum getScoreBySymbol(char symbol) {
        for (ScoreEnum scoreEnum : values()) {
            if (scoreEnum.symbol == symbol) {
                return scoreEnum;
            }
        }

        return null;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
