import java.awt.Color;

public class Example {
    static boolean show = false;

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void showGraph(Comparable[] a, int slash, int pointer, long delay) {
        StdDraw.clear();
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdDraw.setPenColor(i == pointer ? Color.RED : (i > slash ? Color.lightGray : Color.darkGray));
            double rw = 0.5 / (N + 1);
            double x = 1.0 * i / N + rw;
            double y = Double.parseDouble(a[i].toString()) / 2.0;
            StdDraw.filledRectangle(x, y, rw, y);
        }
        try {
            Thread.sleep(delay);
        } catch (Exception e) {}
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) // Note OutOfBound
                return false;
        return true;
    }

    public static boolean getShow() {
        return show;
    }

    public static void setShow(boolean para) {
        show = para;
    }

    public static void main(String[] args) {
        // String[] a = In.readStrings();
        // sort(a);
        setShow(true);
        
        // Sample input: "Insertion 10"
        String alg = StdIn.readString();
        int N = StdIn.readInt();

        Double[] a = new Double[N];
        for (int i = 0; i < a.length; i++) 
            a[i] = StdRandom.uniform();

        SortCompare.time(alg, a);
    }

}