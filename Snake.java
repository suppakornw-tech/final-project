import java.util.ArrayList;

public class Snake {

    private int snake_x;
    private int snake_y;

    // --- PLEAES READ THIS. THIS IS NOT AI SLOP!!! and tell me if you a better idea how to do this ---

    // why InnerSnake is public?
    // answer: to be able to print the body we need to use this variable in the Game.java
    //
    // is it safe?
    // answer: impotant record are immutable, that mean InnerSnake can be change the value after it have been created.
    // but we still be able to created new in to the InnerSnake and that is not we will to have.
    // so we can fix that by check InnerSnake on the checkRep. to make sure that the new value is what we allow to create
    public record InnerSnake(int x, int y) {}

    private ArrayList<InnerSnake> body = new ArrayList<>();

    private int board_x;
    private int board_y;

    private String direction;

    public Snake(int board_x, int board_y) {
        this.snake_x = 2;
        this.snake_y = 3;
        body.add(new InnerSnake(2, 4));

        this.board_x = board_x;
        this.board_y = board_y;

        this.direction = "right";
        checkRep();
    }

    // public Snake(
    //     int snake_x,
    //     int snake_y,
    //     int snake_length,
    //     int board_x,
    //     int board_y,
    //     String direction
    // ) {
    //     this.snake_x = snake_x;
    //     this.snake_y = snake_y;

    //     this.board_x = board_x;
    //     this.board_y = board_y;

    //     this.direction = direction;
    //     checkRep();
    // }

    public void checkRep() {}

    public int getX() {
        return snake_x;
    }

    public int getY() {
        return snake_y;
    }

    public ArrayList<InnerSnake> getBody() {
        return body;
    }

    public String getDirection(String direction) {
        return this.direction;
    }

    public void setX(int x) {
        this.snake_x = x;
        checkRep();
    }

    public void setY(int y) {
        this.snake_y = y;

        checkRep();
    }

    public void setBody(int x, int y, int index) {
        body.set(index, new InnerSnake(x, y));
        checkRep();
    }

    public void setDirection(String direction) {
        if (
            direction.contains("top") ||
            direction.contains("bottom") ||
            direction.contains("left") ||
            direction.contains("right")
        ) this.direction = direction;
        checkRep();
    }

    public boolean move(int apple_x, int apple_y) {
        // check if snake exit the board
        if (
            getX() == 0 ||
            getX() == board_x - 1 ||
            getY() == 0 ||
            getY() == board_y - 1
        ) return false;

        // get tail poistion
        int tail_x = body.get(body.size() - 1).x;
        int tail_y = body.get(body.size() - 1).y;

        // move body
        int current_index = 0;
        int prev_body_x = 0;
        int prev_body_y = 0;
        for (Snake.InnerSnake b : body) {
            if (current_index == 0) {
                setBody(getX(), getY(), current_index);
            } else {
                setBody(prev_body_x, prev_body_y, current_index);
            }
            prev_body_x = b.x();
            prev_body_y = b.y();
            current_index += 1;
        }

        // move head
        if (this.direction.equals("top")) {
            setY(getY() - 1);
            checkRep();
        } else if (this.direction.equals("bottom")) {
            setY(getY() + 1);
            checkRep();
        } else if (this.direction.equals("left")) {
            setX(getX() - 1);
            checkRep();
        } else if (this.direction.equals("right")) {
            setX(getX() + 1);
        }

        // eat apple
        if (getX() == apple_x && getY() == apple_y) growTail(tail_x, tail_y);

        checkRep();
        return true;
    }

    public void growTail(int x, int y) {
        body.add(new InnerSnake(x, y));
        checkRep();
    }
}
