package pursuitDomain;

import java.util.ArrayList;

public abstract class Controller {
	
	protected ArrayList<Action> actionVector;
	
	public Controller() {
		updateActionVector();
	}
	
	public void updateActionVector(){
		for(Action a : Action.values())
		{
			actionVector.add(a);
		}
	}
	
	public abstract Action act();

}
