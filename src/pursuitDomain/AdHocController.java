package pursuitDomain;

public class AdHocController extends Controller{
	
	private Perception perception;
	private Environment environment;
	
	
	public AdHocController(Environment e) {
		environment = e;
	}
	@Override
	public Action act() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void  setPerception(Perception p)
	{
		this.perception = p;
	}
	
	

}
