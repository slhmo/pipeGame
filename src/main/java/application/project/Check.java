package application.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;

public class Check {
    int[][] mapStates;
    boolean[][] deadEnds;
    Queue<ArrayList<Integer>> queue = new LinkedList<>();

    /// 1:moveUp     2: moveDown     3: moveRight    4: moveLeft
    Map<Integer, ArrayList<Integer>> availableMoves = Map.ofEntries(
            Map.entry(0, new ArrayList<Integer>(List.of())),
            Map.entry(1, new ArrayList<Integer>(Arrays.asList(1, 2))),
            Map.entry(2, new ArrayList<Integer>(Arrays.asList(3, 4))),
            Map.entry(3, new ArrayList<Integer>(Arrays.asList(1, 3))),
            Map.entry(4, new ArrayList<Integer>(Arrays.asList(2, 3))),
            Map.entry(5, new ArrayList<Integer>(Arrays.asList(2, 4))),
            Map.entry(6, new ArrayList<Integer>(Arrays.asList(1, 4))),
            Map.entry(7, new ArrayList<Integer>(List.of(2))),
            Map.entry(8, new ArrayList<Integer>(List.of())),
            Map.entry(9, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))),
            Map.entry(10, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))),
            Map.entry(11, new ArrayList<Integer>(Arrays.asList(1, 2))),
            Map.entry(12, new ArrayList<Integer>(Arrays.asList(3, 4))),
            Map.entry(13, new ArrayList<Integer>(Arrays.asList(1, 3))),
            Map.entry(14, new ArrayList<Integer>(Arrays.asList(2, 3))),
            Map.entry(15, new ArrayList<Integer>(Arrays.asList(2, 4))),
            Map.entry(16, new ArrayList<Integer>(Arrays.asList(1, 4)))
    );

    public Check(int[][] mapStates) {
        this.mapStates = mapStates;
        deadEnds = new boolean[mapStates.length][mapStates[0].length];
    }

    private int findInputPipe() {
        for (int column = 0; column< mapStates[0].length; column++) {
            if (mapStates[0][column] == 7) {return column;}
        }
    return -1;
    }

    private void moveUp(int row, int column) {
        boolean deadEnd = true;
        int[] acceptableStates = new int[]{1, 2, 3, 4, 5, 6, 9, 10, 11, 13, 14, 15, 16};
        for (int acceptableState : acceptableStates) {
            if (mapStates[row - 1][column] == acceptableState) {
                deadEnd = false;
                break;
            }
        }
        if (deadEnd) {deadEnds[row-1][column] = true;}
    }
    private void moveDown(int row, int column) {
        boolean deadEnd = true;
        int[] acceptableStates = new int[]{1, 2, 3, 4, 5, 6, 9, 10, 11, 13, 14, 15, 16};
        for (int acceptableState : acceptableStates) {
            if (mapStates[row + 1][column] == acceptableState) {
                deadEnd = false;
                break;
            }
        }
        if (deadEnd) {deadEnds[row+1][column] = true;}
    }
    private void moveRight(int row, int column) {
        boolean deadEnd = true;
        int[] acceptableStates = new int[]{1, 2, 3, 4, 5, 6, 9, 10, 11, 13, 14, 15, 16};
        for (int acceptableState : acceptableStates) {
            if (mapStates[row][column+1] == acceptableState) {
                deadEnd = false;
                break;
            }
        }
        if (deadEnd) {deadEnds[row][column+1] = true;}
    }
    private void moveLeft(int row, int column) {
        boolean deadEnd = true;
        int[] acceptableStates = new int[]{1, 2, 3, 4, 5, 6, 9, 10, 11, 13, 14, 15, 16};
        for (int acceptableState : acceptableStates) {
            if (mapStates[row][column-1] == acceptableState) {
                deadEnd = false;
                break;
            }
        }
        if (deadEnd) {deadEnds[row][column-1] = true;}
    }

    private void findAllSolutions() {
        int inputPipeColumn = findInputPipe();

    }
}
