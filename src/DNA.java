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


        int max_count = 0;
        int i = 0;
        while(i <= sequence.length() - STR.length()){
            int current_count = 0;

            while (current_hash == STR_hash && i <= sequence.length() - STR.length()){
                current_count++;
                i += STR.length();
                // If we're not at the end, update the hash to the next window
                if (i <= sequence.length() - STR.length()) {

                    current_hash = 0;
                    for (int j = 0; j < STR.length(); j++) {
                        current_hash = (current_hash * BASE + sequence.charAt(i + j)) % MOD;
                    }
                }
            }
            if (max_count < current_count){
                max_count = current_count;
            }
            if (current_count == 0){
                current_hash = ((current_hash + MOD) - (sequence.charAt(i) * base_power) % MOD) % MOD;
                if (i + STR.length() < sequence.length()){
                    current_hash = (current_hash * BASE + sequence.charAt(i + STR.length())) % MOD;
                }
                i++;
            }

        }

        return max_count;
    }
}
