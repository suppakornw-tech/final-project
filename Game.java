import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws Exception {
        // create board. snake, apple
        Board board = new Board();
        Snake snake = new Snake(board.getRow(), board.getColumn());
        Apple apple = new Apple(snake.getX(), snake.getY());

        // write snake, apple
        board.write(snake.getX(), snake.getY(), "1");

        for (Snake.InnerSnake b : snake.getBody()) {
            board.write(b.x(), b.y(), "1");
        }

        board.write(apple.getX(), apple.getY(), "4");

        // -------------------- GAME START  --------------------

        // print board
        board.print();

        // sleep 1 second
        Thread.sleep(1000);

        // running game
        while (true) {
            // only use for testing
            //
            // remove if gui is compelete
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter diretion: ");
            String direction = scanner.nextLine();

            scanner.close();

            snake.setDirection(direction);

            // move snake
            boolean isSnakeOut = snake.move(apple.getX(), apple.getY());
            if (
                snake.getX() == apple.getX() && snake.getY() == apple.getY()
            ) apple = new Apple(snake.getX(), snake.getY());

            // game over if snake exit the board
            //
            // if return is false that mean sanke is out of the board
            // if return is true that mean snake will on the board
            if (!isSnakeOut) {
                System.out.println("Game Over!!!");
                break;
            }

            // clear board
            board.clearBoard();

            // write snake, apple
            board.write(snake.getX(), snake.getY(), "1");

            for (Snake.InnerSnake b : snake.getBody()) {
                board.write(b.x(), b.y(), "1");
            }

            board.write(apple.getX(), apple.getY(), "4");

            // print board
            board.print();

            // sleep 1 second
            Thread.sleep(1000);
        }
    }
}
