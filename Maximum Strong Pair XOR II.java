import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int maximumStrongPairXor(int[] A) {
        int res = 0;
        for (int i = 20; i >= 0; --i) {
            res <<= 1;
            Map<Integer, Integer> pref = new HashMap<>();
            Map<Integer, Integer> pref2 = new HashMap<>();
            for (int a : A) {
                int p = a >> i;
                if (!pref.containsKey(p)) {
                    pref.put(p, a);
                    pref2.put(p, a);
                }
                pref.put(p, Math.min(pref.get(p), a));
                pref2.put(p, Math.max(pref2.get(p), a));
            }
            for (Map.Entry<Integer, Integer> entry : pref.entrySet()) {
                int x = entry.getKey();
                int y = res ^ 1 ^ x;
                if (x >= y && pref.containsKey(y) && pref.get(x) <= pref2.get(y) * 2) {
                    res |= 1;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int result = maximumStrongPairXor(A);
        System.out.println(result);
    }
}


