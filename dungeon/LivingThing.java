package dungeon;

public abstract class LivingThing {

    private int x;
    private int y;

    public LivingThing(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equal(int x, int y) {
        return (this.x == x && this.y == y);
    }

    public String toString() {
        return y + " " + x;
    }

}