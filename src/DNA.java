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

        // Calculates STR value
        long STR_hash = 0;
        for (int i = 0; i < STR.length(); i++){
            STR_hash = (STR_hash * BASE + (STR.charAt(i) - 'A')) % MOD;
        }

        // Calculates value of first str.length() characters
        long current_hash = 0;
        for (int i = 0; i < STR.length(); i++){
            current_hash = (current_hash * BASE + (sequence.charAt(i) - 'A')) % MOD;
        }

        // Calculates value of base^str.length() to simply later calculations
        long base_power = 1;
        for (int i = 0; i < STR.length(); i++){
            base_power = (base_power * BASE) % MOD;
        }
        // Makes it equal to str.length() - 1
        base_power /= BASE;

        int current_count = 0;
        int max_count = 0;
        for (int i = STR.length(); i <= sequence.length() - 1; i++){

            if (current_hash == STR_hash){
                current_count++;
            }
            else{
                if (max_count < current_count){
                    max_count = current_count;
                }
                current_count = 0;
            }
            if (i < STR.length()){
                current_hash = ((current_hash + MOD) - (STR.charAt(i - STR.length()) * base_power) % MOD) % MOD;
                current_hash = ((current_hash * BASE) + (sequence.charAt(i) - 'A')) % MOD;
            }

        }



        return max_count;
    }
}
