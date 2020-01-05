package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {

    private int length;
    private int height;

    private boolean vampiresMove;
    private Player p;
    private ArrayList<Vampire> vs;
    private final Scanner sc;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        sc = new Scanner(System.in);
        this.length = length;
        this.height = height;

        this.vampiresMove = vampiresMove;
        this.p = new Player(0, 0, moves);
        vs = new ArrayList<Vampire>();
        for (int i = 0; i < vampires; i++) {
            vs.add(new Vampire((int) (Math.random() * (length)), (int) (Math.random() * (height))));
        }

    }

    public void run() {

        while (true) {
            print();
            String ans = sc.nextLine();
            read(ans);
            removeVamp();

            if (p.canMove()) {
                p.move();
                if (vs.size() == 0) {
                    System.out.println("YOU WIN");
                    return;
                }

            } else {
                if (vs.size() == 0) {
                    System.out.println("YOU WIN");
                    return;
                } else {
                    System.out.println("YOU LOSE");
                    return;
                }
            }
            if (vampiresMove) {

                moveVamps();
            }

        }

    }

    public void print() {
        System.out.println(p.getMoves());
        System.out.println("");
        System.out.println("@ " + p);
        for (Vampire v : vs) {
            System.out.println("v " + v);
        }
        System.out.println("");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (p.equal(i, j)) {
                    System.out.print("@");
                } else if (vampThere(i, j)) {
                    System.out.print("v");
                } else {
                    System.out.print(".");
                }

            }
            System.out.println("");
        }
        System.out.println("");

    }

    public boolean vampThere(int x, int y) {
        for (Vampire v : vs) {
            if (v.equal(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void read(String s) {
        int len = s.length();
        if (len == 0) {
            return;
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'w') {
                if (p.getX() - 1 >= 0) {
                    p.move(-1, 0);
                }

            } else if (s.charAt(i) == 'a') {
                if (p.getY() - 1 >= 0) {
                    p.move(0, -1);
                }

            } else if (s.charAt(i) == 's') {
                if (p.getX() + 1 < this.height) {
                    p.move(1, 0);
                }

            } else if (s.charAt(i) == 'd') {
                if (p.getY() + 1 < this.length) {
                    p.move(0, 1);
                }

            }
        }

    }

    public void removeVamp() {
        ArrayList<Vampire> toBeRemoved = new ArrayList<Vampire>();
        for (Vampire v : vs) {
            if (v.getX() == p.getX() && v.getY() == p.getY()) {
                toBeRemoved.add(v);
            }
        }
        vs.removeAll(toBeRemoved);
    }

    public void moveVamps() {
        for (Vampire v : vs) {
            int randomX = (int) (Math.random() * 3 - 1);
            int randomY = (int) (Math.random() * 3 - 1);
            if (v.getX() + randomX >= 0 && v.getX() + randomX < height) {
                v.move(randomX, 0);
            }
            if (v.getY() + randomY >= 0 && v.getY() + randomY < height) {
                v.move(0, randomY);
            }

        }
    }
}