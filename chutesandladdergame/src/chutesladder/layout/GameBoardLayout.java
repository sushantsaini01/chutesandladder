package chutesladder.layout;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameBoardLayout {

    private static int winnerSquarePosition = 100;
    private static Map<Integer, Integer> chutesMap;
    private static Map<Integer, Integer> laddersMap;
    private static Set<Integer> passThroughSet;
    private static Set<Integer> arrowSet;

    public static void loader() {
        // default postions of ladder based on specs
        laddersMap = new HashMap<>();
        laddersMap.put(1, 38);
        laddersMap.put(4, 14);
        laddersMap.put(9, 31);
        laddersMap.put(28, 84);
        laddersMap.put(21, 42);
        laddersMap.put(36, 44);
        laddersMap.put(51, 68);
        laddersMap.put(71, 91);
        laddersMap.put(80, 100);

        // default postions of chutes based on specs
        chutesMap = new HashMap<>();
        chutesMap.put(98, 78);
        chutesMap.put(95, 75);
        chutesMap.put(93, 73);
        chutesMap.put(87, 24);
        chutesMap.put(64, 60);
        chutesMap.put(62, 19);
        chutesMap.put(56, 53);
        chutesMap.put(49, 11);
        chutesMap.put(47, 26);
        chutesMap.put(16, 6);

        // default postions of passthrough based on specs
        passThroughSet = new HashSet<>();
        passThroughSet.add(5);
        passThroughSet.add(12);
        passThroughSet.add(17);
        passThroughSet.add(18);
        passThroughSet.add(20);
        passThroughSet.add(22);
        passThroughSet.add(23);
        passThroughSet.add(27);
        passThroughSet.add(29);
        passThroughSet.add(32);
        passThroughSet.add(33);
        passThroughSet.add(34);
        passThroughSet.add(35);
        passThroughSet.add(39);
        passThroughSet.add(40);
        passThroughSet.add(41);
        passThroughSet.add(43);
        passThroughSet.add(46);
        passThroughSet.add(48);
        passThroughSet.add(52);
        passThroughSet.add(55);
        passThroughSet.add(57);
        passThroughSet.add(58);
        passThroughSet.add(59);
        passThroughSet.add(63);
        passThroughSet.add(65);
        passThroughSet.add(66);
        passThroughSet.add(68);
        passThroughSet.add(69);
        passThroughSet.add(74);
        passThroughSet.add(76);
        passThroughSet.add(77);
        passThroughSet.add(81);
        passThroughSet.add(82);
        passThroughSet.add(83);
        passThroughSet.add(85);
        passThroughSet.add(86);
        passThroughSet.add(88);
        passThroughSet.add(89);
        passThroughSet.add(90);
        passThroughSet.add(92);
        passThroughSet.add(96);
        passThroughSet.add(99);

        // default postions of arrows based on specs
        arrowSet = new HashSet<>();
        arrowSet.add(10);
        arrowSet.add(20);
        arrowSet.add(30);
        arrowSet.add(40);
        arrowSet.add(50);
        arrowSet.add(60);
        arrowSet.add(70);
        arrowSet.add(80);
        arrowSet.add(90);

    }

    public static boolean isLadder(int squareLocation) {
        return laddersMap.containsKey(squareLocation);
    }

    public static boolean isChute(int squareLocation) {
        return chutesMap.containsKey(squareLocation);
    }

    public static boolean isWinner(int squareLocation) {

        return (winnerSquarePosition == squareLocation);
    }

    public static int getChuteTrail(int position) {

        return chutesMap.get(position);
    }

    public static int getLadderTop(int position) {

        return laddersMap.get(position);
    }

    public static boolean isValidMove(int position) {

        return position <= winnerSquarePosition;
    }

    public static boolean isArrow(int nextPosition) {
        return arrowSet.contains(nextPosition);
    }

    public static boolean isPassThrough(int nextPosition) {
        return arrowSet.contains(nextPosition);
    }
}
