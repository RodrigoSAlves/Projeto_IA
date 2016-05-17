package pursuitDomain;

import java.awt.Color;
import java.util.ArrayList;

import controllers.Controller;

public class Predator extends Agent {
   
    private Controller controller;
    private Perception perception;
    private Predator[] predator;

    public Predator(Cell cell, Controller c) {
        super(cell, Color.BLUE);
        controller = c;
    }

    @Override
    public void act(Environment environment) {
        buildPerception(environment);
        
        execute(decide(), environment);
    }

    //Predator's coordinates relative to the Prey
	private Perception buildPerception(Environment environment) {
    	predator = (Predator[]) environment.getPredators().toArray();
    	Position preyPos;
    	Position[] predPositions = new Position[predator.length];
    	
    	for (int i = 0; i < predator.length; i++) {
			predPositions[i] = new Position(predator[i].getCell().getLine(), predator[i].getCell().getColumn());
		}
		preyPos = new Position(environment.getPrey().getCell().getLine(), environment.getPrey().getCell().getColumn());

        perception = new Perception(preyPos, predPositions);
        
    	return perception;
    }

    private Action decide() {
        return controller.act();
        
    }
    
    public void setController(Controller c){
    	this.controller = c;
    }
    
    public void setAvailableActions(ArrayList<Action> actions)
    {
    	controller.setAvailableActions(actions);
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

   
   