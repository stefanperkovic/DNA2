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

        if (sequence.length() < STR.length()){
            return 0;
        }

        // Calculates STR value
        long STR_hash = 0;
        for (int i = 0; i < STR.length(); i++) {
            STR_hash = (STR_hash * BASE + STR.charAt(i)) % MOD;
        }

        // Calculates value of first str.length() characters
        long current_hash = 0;
        for (int i = 0; i < STR.length(); i++) {
            current_hash = (current_hash * BASE + sequence.charAt(i)) % MOD;
        }

        // Calculates value of base^str.length() to simply later calculations
        long base_power = 1;
        for (int i = 1; i < STR.length(); i++){
            base_power = (base_power * BASE) % MOD;
        }

        int current_count = 0;
        int max_count = 0;
        for (int i = STR.length(); i < sequence.length(); i++){

            long temp_hash = current_hash;
            int temp_pos = i;
            while (temp_hash == STR_hash){
                current_count++;
                if (max_count < current_count){
                    max_count = current_count;
                }
                // If we're not at the end, update the hash to the next window
                if (temp_pos + STR.length() < sequence.length()) {
                    for (int j = temp_pos; j < STR.length() + temp_pos; j++) {
                        temp_hash = (temp_hash * BASE + sequence.charAt(j)) % MOD;
                    }
                }
                temp_pos += STR.length();

            }
            current_count = 0;
            current_hash = ((current_hash + MOD) - (sequence.charAt(i - STR.length()) * base_power) % MOD) % MOD;
            current_hash = ((current_hash * BASE) + sequence.charAt(i)) % MOD;


        }

        return max_count;
    }
}
