/* Rodrigo Alves
 * André Roque
 */

package pursuitDomain;

import java.util.ArrayList;
import java.util.Random;

public class RandomController extends Controller {
	
	private Random random;
	
	public RandomController(long seed) {
		super();
		random = new Random(seed);
	}
	
	public Action act()
	{
		return actionVector.get(random.nextInt(actionVector.size()));
	}
	
}
