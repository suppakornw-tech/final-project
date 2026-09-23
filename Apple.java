import java.util.Random;

public class Apple {

    Random random = new Random();
    boolean isEmpty = false;

    private int x;
    private int y;

    Apple(int pos_snake_x, int pos_snake_y) {
        while (!isEmpty) {
            int random_x = random.nextInt(10);
            int random_y = random.nextInt(10);

            if (random_x != pos_snake_x && random_y != pos_snake_y) {
                setX(random_x);
                setY(random_y);
                isEmpty = true;
            }
        }

        checkRep();
    }

    public void checkRep() {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
        checkRep();
    }

    public void setY(int y) {
        this.y = y;

        checkRep();
    }
}
