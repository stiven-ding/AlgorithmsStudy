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

    public static void showGraph(Comparable[] a, int slash, int pointer) {
        StdDraw.clear();
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdDraw.setPenColor(i == pointer ? Color.RED : (i > slash ? Color.lightGray : Color.darkGray));
            double rw = 0.5 / (N+1);
            double x = 1.0 * i / N + rw ;
            double y = Double.parseDouble(a[i].toString()) / 2.0;
            StdDraw.filledRectangle(x, y, rw, y);
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            if (less(a[i], a[i - 1]))
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
        setShow(false);
        StdOut.print("Input the size of array: ");
        int N = StdIn.readInt();
        
        Double[] a = new Double[N];
        Double[] b = new Double[N];

        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
            b[i] = a [i];
        }
        
        try {
            Stopwatch timer = new Stopwatch();

            Selection.sort(a);
            StdOut.println("Selection takes " + timer.elapsedTime());
            
            timer = new Stopwatch();
            Insertion.sort(a);
            StdOut.println("Insertion takes " + timer.elapsedTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}