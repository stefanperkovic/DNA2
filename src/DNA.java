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
        map[0] = 0b00;
        map[2] = 0b01;
        map[19] = 0b10;
        map[6] = 0b11;
        int seq = 0;

        for (int i = 0; i < STR.length(); i++){
            seq = seq << 2;
            seq += map[STR.charAt(i) - 'A'];
        }



        int max_count = 0;
        for (int i = 0; i < sequence.length(); i++){

            int start = 0;
            for (int j = 0; j < STR.length(); j++) {
                start = start << 2;
                start += map[sequence.charAt(i + j) - 'A'];
            }




            int current_count = 0;
            while (start == seq){
                i+= STR.length();
                start = 0;
                for (int j = 0; j < STR.length(); j++) {
                    start = start << 2;
                    start += map[sequence.charAt(i + j) - 'A'];
                }


                current_count++;
            }



            if (max_count < current_count){
                max_count = current_count;
            }



        }





        return 0;
    }
}
