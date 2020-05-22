// p. 251
// Insertion sorts uses ~{N^2}/4 compares and ~{N^2}/4 exchanges.

public class Insertion {
    public static void sort(Comparable[] a) throws InterruptedException {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Example.less(a[j], a[j - 1]); j--) {
                Example.exch(a, j, j - 1);
                if (Example.getShow()){
                    Example.showGraph(a, i, j-1);
                    Thread.sleep(200);
                }
            }
            
            // Equivalent to code below from lecture notes: 
            //
            //     for (int j = i; j > 0; j--)
            //         if (less(a[j], a[j - 1]))
            //            exch(a, j, j - 1);
            //        else
            //            break;

        }
    }
}