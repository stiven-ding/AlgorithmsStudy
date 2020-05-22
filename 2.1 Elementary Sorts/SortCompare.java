// p. 256
// Modifications are made on the sample code.

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Double[] b = new Double[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i];

        Stopwatch timer = new Stopwatch();
        if (alg.equals("Selection"))
            Selection.sort(b);
        if (alg.equals("Insertion"))
            Insertion.sort(b);
        if (alg.equals("Shell"))
            Shell.sort(b);
        /*if (alg.equals("Merge"))
            Merge.sort(b);
        if (alg.equals("Quick"))
            Quick.sort(b);
        if (alg.equals("Heap"))
            Heap.sort(b);*/

        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        String alg1 = StdIn.readString();
        String alg2 = StdIn.readString();
        int N = StdIn.readInt();
        // Sample input: "Selection Insertion 5000"

        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();

        double t1 = time(alg1, a);
        double t2 = time(alg2, a);

        StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s \n", t2 / t1, alg2);
        StdOut.printf("    %s takes %.2f, %s takes %.2f", alg1, t1, alg2, t2);
    }
}