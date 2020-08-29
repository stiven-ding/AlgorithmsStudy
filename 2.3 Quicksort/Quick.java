public class Quick {
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo]; // partitioning item
        while (true) {
            while (Example.less(a[++i], v)) if (i == hi) break;
            while (Example.less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            Example.exch(a, i, j);
        }
        Example.exch(a, lo, j);
        return j;
    }
}