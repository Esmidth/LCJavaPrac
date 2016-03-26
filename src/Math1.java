import static java.lang.Math.abs;

/**
 * Created by Great Esmidth on 2016/3/20.
 * Stay Foolish
 */
public class Math1 {
	public static void main(String[] args) {
		double dx = -50;
		double dy = -50;
		double theta1 = 0;
		double theta2 = 0;
		double yaw = 0;
		if (dy >= 0) {
			theta1 = Math.atan(dy / dx) * 360 / (2 * 3.1415);
			if (dx <= 0) {
				theta1 += 180;
			}
		} else if (dy <= 0) {
			theta1 = Math.atan(dy / dx) * 360 / (2 * 3.1415);
			if (dx <= 0) {
				theta1 += 180;
			} else {
				theta1 += 360;
			}
		}
		System.out.println(theta1);
		if (abs(theta1 - theta2) >= 90) {
		} else {
			yaw = theta2 - theta1;
		}

	}
}
