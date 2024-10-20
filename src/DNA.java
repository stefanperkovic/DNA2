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

    private static final int BASE = 256;
    private static final long MOD = 1000000007;

    public static int STRCount(String sequence, String STR) {

        long STR_hash = 0;
        for (int i = 0; i < STR.length(); i++){
            STR_hash = (STR_hash * BASE + (STR.charAt(i) - 'A')) % MOD;
        }

        long current_hash = 0;
        for (int i = 0; i < STR.length(); i++){
            current_hash = (current_hash * BASE + (sequence.charAt(i) - 'A')) % MOD;
        }


        int current_count = 0;
        int max_count = 0;
        for (int i = 0; i < sequence.length() - STR.length(); i++){

            if (current_hash == STR_hash){
                current_count++;

            }
            else{
                current_count = 0;
            }



            if (max_count < current_count){
                max_count = current_count;
            }



        }





        return 0;
    }
}
