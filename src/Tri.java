public class Tri {

    private Point i, j, k;
    private static final double CONV = 180/Math.PI;

    public Tri(Point i, Point j, Point k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public Point getI() {
        return i;
    }

    public Point getJ() {
        return j;
    }

    public Point getK() {
        return k;
    }

    /*public boolean equals (Tri o) {
        boolean try1_i = i.equals(o.j);
        boolean try2_i = i.equals(o.k);

        boolean try1_j = j.equals(o.k);
        boolean try2_j = j.equals(o.i);

        boolean try1_k = k.equals(o.i);
        boolean try2_k = k.equals(o.j);

        boolean try1 = try1_i && try1_j && try1_k;
        boolean try2 = try2_i && try2_j && try2_k;

        return (try1 && !try2) || (try2 && !try1);
    }*/
    public boolean equals (Tri o) {
        Point i_ = o.i;
        Point j_ = o.j;
        Point k_ = o.k;

        boolean b1 = (i == j_ || i == k_) && (j == i_ || j == k_) && (k == i_ || k == j_);
        boolean b2 = (i == i_) && ((j == k_) || k == j_);
        boolean b3 = (j == j_) && ((i == k_) || k == i_);
        boolean b4 = (k == k_) && ((i == j_) || j == i_);
        return b1 || b2 || b3 || b4;
    }

    private static double getLen (Point i, Point j) {
        int x = Math.abs(i.getX() - j.getX());
        int y = Math.abs(i.getY()) - j.getY();
        double hyp = Math.sqrt(x*x + y*y);
        return hyp;
    }
    private static double getAngle (double x, double y, double z) {
        double top = x*x + y*y - z*z;
        double bottom = 2 * x * y;
        double ang = Math.acos(top / bottom) * CONV;
        return ang;
    }

    public boolean isRat () {
        double i_j = getLen(i, j);
        double j_k = getLen(j, k);
        double i_k = getLen(i, k);

        double a1 = getAngle(i_j, j_k, i_k);
        double a2 = getAngle(i_j, i_k, j_k);
        double a3 = getAngle(j_k, i_k, i_j);

        a1 = Math.round(a1);
        a2 = Math.round(a2);
        a3 = Math.round(a3);


        return a1 == 90 || a2 == 90 || a3 == 90;
    }

    @Override
    public String toString() {
        return "Tri{" +
                "i=" + i +
                ", j=" + j +
                ", k=" + k +
                '}';
    }
}
