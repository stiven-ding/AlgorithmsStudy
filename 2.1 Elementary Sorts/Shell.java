// p. 259
// The worst case is appromaxited proportional to N^{3/2}, which is not an accurate model (currently nonexisting).
// Shell is practical and safe for industrial purposes (bzip2, /linux/kernel/groups.c, uClibc, etc.)

public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1; // set a starting h no less than N/3, which equals {3h + 1}
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && Example.less(a[j], a[j - h]); j -= h) { // for i = h, j moves from h to every {j - k*h}
                    Example.exch(a, j, j - h);

                    if (Example.getShow())
                        Example.showGraph(a, i, j, 200);

                }
            }
            h = h / 3;
        }
    }
}