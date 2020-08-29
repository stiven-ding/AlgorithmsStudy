// p. 278
// Bottom-up mergesort uses 1/2 N lg N to N log N compares and at most 6 N log N array accesses.

public class MergeBU {
    private static Comparable[] aux;

    public static void sort (Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz =1; sz < N; sz = sz * 2) 
            for (int lo = 0; lo < N-sz; lo += sz * 2)
                Merge.merge(a, lo, lo+sz-1, Math.min(lo+sz*2-1, N-1));
    }
}