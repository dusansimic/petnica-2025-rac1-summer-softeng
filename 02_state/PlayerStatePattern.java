interface PlayerState {
    void move(Player player);

    void rest(Player player);
}

class WalkingState implements PlayerState {
    @Override
    public void move(Player player) {
        System.out.println("Player is walking...");
    }

    @Override
    public void rest(Player player) {
        System.out.println("Player is getting tired... Switching to Sleeping state.");
        player.setState(new SleepingState());
    }
}

class RunningState implements PlayerState {
    @Override
    public void move(Player player) {
        System.out.println("Player is sprinting fast!");
    }

    @Override
    public void rest(Player player) {
        System.out.println("Player is exhausted from running. Switching to Walking state.");
        player.setState(new WalkingState());
    }
}

class SleepingState implements PlayerState {
    @Override
    public void move(Player player) {
        System.out.println("Player is sleeping... Cannot move.");
    }

    @Override
    public void rest(Player player) {
        System.out.println("Player is well-rested. Switching to Walking state.");
        player.setState(new WalkingState());
    }
}

class Player {
    private PlayerState currentState;

    public Player() {
        this.currentState = new WalkingState(); // Default state
    }

    public void setState(PlayerState state) {
        this.currentState = state;
    }

    public void move() {
        currentState.move(this);
    }

    public void rest() {
        currentState.rest(this);
    }
}

public class PlayerStatePattern {
    public static void main(String[] args) {
        Player player = new Player();

        player.move(); // Walking
        player.rest(); // Switch to Sleeping
        player.move(); // Can't move
        player.rest(); // Switch to Walking
        player.move(); // Sprinting
        player.rest(); // Exhausted, back to walking
    }
}
