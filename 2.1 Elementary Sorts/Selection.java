// p. 249
// Selection sort uses ~{N^2}/2 compares and N exchanges.
// Running time is insensitive to input.

public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (Example.less(a[j], a[min]))
                    min = j;
            Example.exch(a, i, min);

            if (Example.getShow())
                Example.showGraph(a, i, i, 200);

        }
    }
}