/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: Stefan Perkovic
 *</p>
 */

public class DNA {

    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        int[] map = new int[STR.length()];
        map[0] = 00;
        map[2] = 01;
        map[19] = 10;
        map[6] = 11;
        int seq = 0;

        for (int i = 0; i < STR.length(); i++){
            seq = seq << 2;
            seq += map[STR.charAt(i) - 'A'];
        }

        int start = 0;
        for (int i = 0; i < STR.length(); i++){
            start = start << 2;
            start += map[sequence.charAt(i) - 'A'];


        }



        for (int i = 0; i < sequence.length(); i++){




        }





        return 0;
    }
}
