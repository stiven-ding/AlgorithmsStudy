// p.273
// Mergesort uses at most N lg N compares and 6 N lg N array accesses to sort any array of size N.

public class Merge {
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        assert Example.isSorted(a, lo, mid);
        assert Example.isSorted(a, mid + 1, hi);

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            if (i > mid) // after copying the last item on the left
                a[k] = aux[j++];
            else if (j > hi) // after copying the last item on the right
                a[k] = aux[i++];
            else if (Example.less(aux[j], aux[i])) // copy the smaller item
                a[k] = aux[j++];
            else
                a[k] = aux[i++];

        assert Example.isSorted(a, lo, hi);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi-lo/2); 
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    /**
     * $ java -ea MyProgram // enable assertions
     * $ java -da MyProgram // disable assertions (default)
     */

}