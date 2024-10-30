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


    // Calculates the hash for a substring starting at index 0 up to length
    private static long calculateHash(String s, int len) {
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + s.charAt(i)) % MOD;
        }
        return hash;
    }

    public static int STRCount(String sequence, String STR) {

        // If STR is longer than the sequence, there can be no matches
        if (sequence.length() < STR.length()){
            return 0;
        }

        // Calculates the hash value for the STR
        long STR_hash = calculateHash(STR, STR.length());

        // Calculates initial hash of first window in our sequence
        long current_hash = calculateHash(sequence, STR.length());

        // Compute for efficient rolling hash updates
        long base_power = 1;
        for (int i = 1; i < STR.length(); i++){
            base_power = (base_power * BASE) % MOD;
        }

        int max_count = 0;
        int i = 0;
        // Slide through sequence to find consecutive STR matches
        while(i <= sequence.length() - STR.length()){
            int current_count = 0;

            // Count consecutive matches by comparing current window hash to STR hash
            while (current_hash == STR_hash && i <= sequence.length() - STR.length()){
                current_count++;
                i += STR.length();

                // Recalculate hash for the new window if within bounds
                if (i <= sequence.length() - STR.length()) {
                    current_hash = calculateHash(sequence.substring(i, i + STR.length()), STR.length());
                }
            }
            // Track the maximum count of consecutive matches
            if (max_count < current_count){
                max_count = current_count;
            }
            // Slide the window by one character if no match was found
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
