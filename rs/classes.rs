use std::f64::consts::PI;

pub struct point {
    x: i32,
    y: i32
}
pub struct tri<'a> {
    i: &'a point,
    j: &'a point,
    k: &'a point
}

impl point {
    pub fn new(x: i32, y: i32) -> Self {
        point { x, y }
    }

    pub fn x(&self) -> i32 {
        self.x
    }
    pub fn y(&self) -> i32 {
        self.y
    }

    pub fn equals(&self, o: &point) -> bool{
        self.x == o.x && self.y == o.y
    }
}

impl tri<'_> {
    pub fn new(i: &'_ point, j: &'_ point, k: &'_ point) -> Self {
        tri { i, j, k }
    }

    pub fn is_same (&self, o: &tri) -> bool{
        let try1_i = self.i.equals(o.j);
        let try2_i = self.i.equals(o.k);

        let try1_j = self.j.equals(o.i);
        let try2_j = self.j.equals(o.k);

        let try1_k = self.k.equals(o.j);
        let try2_k = self.k.equals(o.i);

        let try1 = try1_i && try1_j && try1_k;
        let try2 = try2_i && try2_j && try2_k;

        (try1 && !try2) || (try2 && !try1)
    }

    pub fn get_len (i: &point, j: &point) -> f32 {
        let x = (i.x() - j.x()).abs();
        let y = (i.y() - j.y()).abs();
        let hyp = ((x*x + y*y) as f32).sqrt();
        hyp
    }
    pub fn get_angle (x: f32, y: f32, z: f32) -> f64 {
        let top_half = x*x + y*y - z*z;
        let bottom_half: f32 = 2.0 * x * y;
        let radians = (top_half / bottom_half).acos();
        let degrees = (radians as f64) * (180.0 / PI);
        degrees
    }

    pub fn is_rat (&self) -> bool {
        let i_j = tri::get_len(&self.i, &self.j);
        let j_k = tri::get_len(&self.j, &self.k);
        let i_k = tri::get_len(&self.i, &self.k);

        let a1 = tri::get_angle(i_j, j_k, i_k);
        let a2 = tri::get_angle(i_j, i_k, j_k);
        let a3 = tri::get_angle (j_k, i_k, i_j);

        let a1 = a1.ceil();
        let a2 = a2.ceil();
        let a3 = a3.ceil();

        let b: bool = a1 == 90.0 || a2 == 90.0 || a3 == 90.0;
        b
    }

}