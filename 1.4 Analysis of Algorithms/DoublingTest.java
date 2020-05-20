// p. 177
// p. 192

public class DoublingTest { // or DoublingRatio
    public static double timeTrial(final int N) {
        final int MAX = 1000000;
        final int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        final Stopwatch timer = new Stopwatch();
        final int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(final String[] args) {
        double prev = timeTrial(128);
        for (int N = 250; true; N += N) {
            final double time = timeTrial(N);
            StdOut.printf("%6d %7.1f", N, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}