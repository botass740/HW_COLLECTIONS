import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Game;
import ru.netology.javaqa.NotRegisteredException;
import ru.netology.javaqa.Player;

public class GameTest {

    @Test
    public void victoryFirstPlayer() {
        Player german = new Player(1, "Герман", 10);
        Player max = new Player(2, "Макс", 15);
        Game game = new Game();

        game.register(german);
        game.register(max);
        int actual = game.round("Макс", "Герман");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void victorySecondPlayer() {
        Player german = new Player(1, "Герман", 15);
        Player max = new Player(2, "Макс", 10);
        Game game = new Game();

        game.register(german);
        game.register(max);
        int actual = game.round("Макс", "Герман");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDrawnGame() {
        Player german = new Player(1, "Герман", 15);
        Player max = new Player(2, "Макс", 15);
        Game game = new Game();

        game.register(german);
        game.register(max);
        int actual = game.round("Макс", "Герман");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerNotRegistered() {
    Player german = new Player(1, "Герман", 15);
    Player max = new Player(2, "Макс", 15);
    Game game = new Game();

        game.register(german);
        game.register(max);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Алекс", "Макс"));
    }

    @Test
    public void testSecondPlayerNotRegistered() {
        Player german = new Player(1, "Герман", 15);
        Player max = new Player(2, "Макс", 15);
        Game game = new Game();

        game.register(german);
        game.register(max);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Герман", "Алекс"));
    }

    @Test
    public void testPlayerNotRegistered() {
        Player german = new Player(1, "Герман", 15);
        Player max = new Player(2, "Макс", 15);
        Game game = new Game();

        game.register(german);
        game.register(max);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Шурик", "Алекс"));
    }
}
