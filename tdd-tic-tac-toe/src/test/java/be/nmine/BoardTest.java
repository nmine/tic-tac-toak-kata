package be.nmine;

import org.junit.jupiter.api.Test;

import static be.nmine.Position.*;
import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    @Test
    void player_X_fill_top_row_should_win_the_game() {
        //Given
        Board board = new Board();
        //When
        playerXFillTopRow(board);
        //Then
        assertThat(board.isWinningPositionFill(Player.X)).isEqualTo(true);
    }

    @Test
    void player_O_fill_column_center_should_win_the_game() {
        //Given
        Board board = new Board();
        //When
        playerOFillCenterColumn(board);
        //Then
        assertThat(board.isWinningPositionFill(Player.O)).isEqualTo(true);
    }

    private void playerXFillTopRow(Board board) {
        board.setPosition(TOP_LEFT, Player.X);
        board.setPosition(TOP_MIDLLE, Player.X);
        board.setPosition(TOP_RIGHT, Player.X);
    }

    private void playerOFillCenterColumn(Board board) {
        board.setPosition(TOP_LEFT, Player.O);
        board.setPosition(MIDDLE_CENTER, Player.O);
        board.setPosition(BOTTOM_RIGHT, Player.O);
    }
}