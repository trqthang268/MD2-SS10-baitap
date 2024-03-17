package session10_baitap.baitap01;

public class TennisGame extends TennisGameTest{
    public TennisGame(int player1Score, int player2Score, String expectedScore) {
        super(player1Score, player2Score, expectedScore);
    }

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String scoreMessage = "";
        int winScore = 4;
        if (player1Score == player2Score) {
            switch (player1Score) {
                case 0:
                    scoreMessage = LOVE+ALL;
                    break;
                case 1:
                    scoreMessage = FIFTEEN+ALL;
                    break;
                case 2:
                    scoreMessage = THIRTY+ALL;
                    break;
                case 3:
                    scoreMessage = FORTY+ALL;
                    break;
                default:
                    scoreMessage = DEUCE;
                    break;
            }
        } else {
            if (player1Score >= winScore || player2Score >= winScore) {
                scoreMessage = getWinner(player1Score, player2Score);
            } else {
                scoreMessage = getCurrentScore(player1Score, player2Score, scoreMessage);
            }
        }
        return scoreMessage;
    }

    private static String getCurrentScore(int player1Score, int player2Score, String score) {
        int tempScore;
        int maxScoreBeforeMin = 3;
        for (int i = 1; i < maxScoreBeforeMin; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }

    private static String getWinner(int player1Score, int player2Score) {
        String scoreMessage;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) scoreMessage = ADVANTAGE_PLAYER_1;
        else if (minusResult == -1) scoreMessage = ADVANTAGE_PLAYER_2;
        else if (minusResult >= 2) scoreMessage = WIN_FOR_PLAYER_1;
        else scoreMessage = WIN_FOR_PLAYER_2;
        return scoreMessage;
    }
}