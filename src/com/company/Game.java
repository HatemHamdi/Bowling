package com.company;

import java.util.Arrays;

/**
 * @author Hatem Hamdi
 */
public class Game {

    public static int calculateBowlingScore(String gameString) {
        String[] frames = gameString.split("\\s+");
        String[] regularFrames = Arrays.copyOfRange(frames, 0, frames.length > 10 ? 10 : frames.length);

        char[] scores = toChars(regularFrames);
        int total = 0;

        // Calculate regular frames
        total = getTotalScore(scores, total);

        if (frames.length > 10) {

            char[] bonusFrames = toChars(Arrays.copyOfRange(frames, 10, frames.length));
            // Calculate bonus frames
            total = getTotalScore(bonusFrames, total);
        }

        return total;

    }

    private static int getTotalScore(char[] scores, int total) {
        for (int i = 0; i < scores.length; i++) {
            ScoreEnum scoreEnum = ScoreEnum.getScoreBySymbol(scores[i]);
            if (scoreEnum != null) {
                if (scoreEnum == ScoreEnum.STRIKE) {
                    if (i + 1 < scores.length) {
                        total += ScoreEnum.getScoreBySymbol(scores[i + 1]).getValue();
                    }
                    if (i + 2 < scores.length) {
                        total += ScoreEnum.getScoreBySymbol(scores[i + 2]).getValue();
                    }
                }

                if (scoreEnum == ScoreEnum.SPARE) {
                    if (i + 1 < scores.length) {
                        total += ScoreEnum.getScoreBySymbol(scores[i + 1]).getValue();
                    }

                    scoreEnum.setValue(10 - ScoreEnum.getScoreBySymbol(scores[i - 1]).getValue());
                }
                total += scoreEnum.getValue();
            }
        }
        return total;
    }

    static char[] toChars(String[] publicArray) {
        StringBuilder builder = new StringBuilder();
        for (String value : publicArray) {
            builder.append(value);
        }
        return builder.toString().toCharArray();
    }
}

