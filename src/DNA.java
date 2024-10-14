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


        int maxcount = 0;
        for (int i = 0; i < STR.length(); i++){
            if (STR.charAt(i) == 'A'){


            }
            else if (STR.charAt(i) == 'C') {

            }
            else if (STR.charAt(i) == 'T') {

            }
            else{

            }

        }




        for (int i = 0; i < sequence.length(); i++){




        }





        return 0;
    }
}
