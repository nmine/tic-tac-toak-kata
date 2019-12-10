package be.nmine;

import java.util.EnumMap;
import java.util.Map;

import static java.util.Arrays.stream;

public class Board {

    final Map<Position, Player> positions;

    public Board() {
        this.positions = new EnumMap<>(Position.class);
    }

    protected boolean isPositionAlreadyTaken(Position position) {
        return positions.keySet().stream().filter(position1 -> position1 == position).findFirst().isPresent();
    }

    public void setPosition(Position position, Player player) {
        positions.put(position, player);
    }

    public Player getPlayerForPosition(Position position) {
        return positions.entrySet().stream()
                .filter(positionStringEntry -> positionStringEntry.getKey() == position)
                .findFirst()
                .get().getValue();
    }

    public boolean isWinningPositionFill(Player player) {
        return isRowsFilled(player);
    }

    private boolean isRowsFilled(Player player) {
        return isRowFilled(player, WinningPosition.ROW_TOP) ||
                isRowFilled(player, WinningPosition.ROW_BOTTOM) ||
                isRowFilled(player, WinningPosition.ROW_CENTER);
    }

    private boolean isRowFilled(Player player, WinningPosition rowTop) {
        return stream(rowTop.getPositions()).allMatch(
                position -> getPlayerForPosition(position) == player);
    }
}

