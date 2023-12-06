package ist.model;


import java.util.ArrayList;
import java.util.List;

public class TrLockImpl implements IDialLock {
    private int maxTicks;
    private int s1, s2, s3;
    private int currentTick;
    private List<Turn> moves = new ArrayList<>();

    public TrLockImpl(int s1, int s2, int s3, int mTicks) {
        if (s1 < 0 || s2 < 0 || s3 < 0 || mTicks < 0) {
            throw new IllegalArgumentException("Secret digits and maxTicks cannot be negative");
        }

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.maxTicks = mTicks + 1;
    }

    @Override
    public void reset() {
        currentTick = 0;
        moves.clear();
    }

    @Override
    public void left(int t) {
        if (currentTick - t < 0) {
            currentTick = maxTicks + (currentTick - t);
        } else {
            currentTick -= t;
        }

        Turn lt = new Turn(Turn.Direction.L, currentTick);
        moves.add(lt);
    }

    @Override
    public void right(int t) {
        currentTick = (currentTick + t) % maxTicks;
        Turn rt = new Turn(Turn.Direction.R, currentTick);
        moves.add(rt);
    }

    @Override
    public int currentTick() {
        return currentTick;
    }

    @Override
    public boolean pull() {
        List<Turn> firstRightTurns = new ArrayList<>();
        List<Turn> secondLeftTurns = new ArrayList<>();
        List<Turn> thirdRightTurns = new ArrayList<>();

        for (Turn turn : moves) {
            if (turn.dir == Turn.Direction.R) {
                if (!secondLeftTurns.isEmpty()) {
                    return false;
                }
                if (firstRightTurns.isEmpty()) {
                    firstRightTurns.add(turn);
                } else {
                    thirdRightTurns.add(turn);
                }
            } else if (turn.dir == Turn.Direction.L) {
                if (!firstRightTurns.isEmpty() && secondLeftTurns.isEmpty()) {
                    secondLeftTurns.add(turn);
                } else {
                    return false;
                }
            }
        }

        if (firstRightTurns.isEmpty() || secondLeftTurns.isEmpty() || thirdRightTurns.isEmpty()) {
            return false;
        }

        return firstRightTurns.get(firstRightTurns.size() - 1).stopDigit == s1
                && secondLeftTurns.get(secondLeftTurns.size() - 1).stopDigit == s2
                && thirdRightTurns.get(thirdRightTurns.size() - 1).stopDigit == s3;
    }

    @Override
    public String toString() {
        return "Secret Digits: (" + s1 + ", " + s2 + ", " + s3 + ")";
    }
}