public class Rectangle {
    public  static final int DEFAULT_WIDTH =5;
    public static final int DEFAULT_HEIGHT = 5;

    private int x,y,w,h;

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
        this.h = DEFAULT_HEIGHT;
        this.w = DEFAULT_WIDTH;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}
