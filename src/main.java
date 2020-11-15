import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        int count = 0;
        int size = 4;
        Point[] pts = new Point[size * size];
        ArrayList<Tri> works = new ArrayList<>();

        //region init arr
        int a = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                pts[a] = new Point(x, y);
                a++;
            }
        }
        //endregion

        for (int i = 0; i < size*size; i++) {
            for (int j = 0; j < size*size; j++) {
                for (int k = 0; k < size*size; k++) {
                    if (i == 0 && j == 0 && k == 0)
                        continue;

                    Point i_ = pts[i];
                    Point j_ = pts[j];
                    Point k_ = pts[k];

                    if (i_.equals(j_) && j_.equals(k_) && i_.equals(k_)) {
                        continue;
                    }

                    Tri t = new Tri(i_, j_, k_);

                    if(t.isRat()) {
                        boolean f = false;
                        for(Tri o : works) {
                            if(t.equals(o)) {
                                f = true;
                                break;
                            }
                        }
                        if(!f) {
                            works.add(t);
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static void yeet(String[] args) {
        Point i = new Point(0, 0);
        Point j = new Point(0, 1);
        Point k = new Point(1, 1);
        Tri t = new Tri(i, j, k);
        System.out.println(t.isRat());
    }
}
