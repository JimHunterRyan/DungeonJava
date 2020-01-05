package dungeon;

public class Player extends LivingThing {

    private int moves;

    public Player(int x, int y, int moves) {
        super(x, y);
        this.moves = moves;
    }

    public int getMoves() {
        return this.moves;
    }

    public void move() {
        if (this.moves > 1) {
            this.moves--;
        }
    }

    public boolean canMove() {
        return (this.moves > 1);

    }

}
