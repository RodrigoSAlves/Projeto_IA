package pursuitDomain;

import java.awt.Color;
import java.util.Random;

public class Prey extends Agent{

    final private double restProbability;
    private RandomController controller;
    private Random probMoveRandom;
    
    public Prey(Cell cell, double restProbability, long seed){
        super(cell, Color.RED);
        this.restProbability = restProbability;
        this.controller = new RandomController(seed);
        probMoveRandom = new Random();
    }
    
    @Override
    public void act(Environment environment) {
        Action a = controller.act();
        if(probMoveRandom.nextInt(100) > 90)
        {
        	execute(a,environment);
        }
    }
    
    private void execute(Action action, Environment environment) {
        Cell nextCell;
        if (action == Action.NORTH) {
            nextCell = environment.getNorthCell(cell);
        } else if (action == Action.SOUTH) {
            nextCell = environment.getSouthCell(cell);
        } else if (action == Action.WEST) {
            nextCell = environment.getWestCell(cell);
        } else {
            nextCell = environment.getEastCell(cell);
        }

        if (!nextCell.hasAgent()) {
            setCell(nextCell);
        }
    }
}
