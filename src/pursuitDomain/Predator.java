package pursuitDomain;

import java.awt.Color;

public class Predator extends Agent {
   
    private Controller controller;
    

    public Predator(Cell cell, Controller c) {
        super(cell, Color.BLUE);
        
    }

    @Override
    public void act(Environment environment) {
        buildPerception(environment);
        execute(decide(), environment);
    }

    //Predator's coordinates relative to the Prey
    private void buildPerception(Environment environment) {
        //TODO
    }

    private Action decide() {
        return controller.act();
        
    }
    
    public void setController(Controller c){
    	this.controller = c;
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

   
   