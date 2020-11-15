use crate::classes::*;

mod classes;

fn main() {

    let mut count = 0;
    let size: i32 = 4;
    let mut pts: Vec<point> = Vec::with_capacity((size * size) as usize);
    let mut works: Vec<tri> = Vec::with_capacity(((size * size) as usize) ^ 3);

    //region init arr
    let mut i = 0;
    for x in 0..size {
        for y in 0..size {
            pts[i] = point::new(x, y);
            i += 1;
        }
    }
    //endregion

    for i in 0..size {
        for j in 0..size {
            for k in 0..size {
                let i_pt: &point = &pts[i as usize];
                let j_pt: &point = &pts[j as usize];
                let k_pt: &point = &pts[k as usize];

                if i_pt.equals(j_pt)|| j_pt.equals(k_pt) || i_pt.equals(k_pt) {
                    continue;
                }

                let t = tri::new(i_pt, j_pt, k_pt);
                if t.is_rat() {
                    let mut found = false;
                    for o in works.iter() {
                        if t.is_same(o) {
                            found = true;
                            break;
                        }
                    }
                    if !found {
                        works.push(t);
                        count += 1;
                    }
                }
            }
        }
    }

    println!("{}", count);
}
