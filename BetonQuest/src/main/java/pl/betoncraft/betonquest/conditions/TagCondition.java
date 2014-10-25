/**
 * 
 */
package pl.betoncraft.betonquest.conditions;

import pl.betoncraft.betonquest.BetonQuest;
import pl.betoncraft.betonquest.core.Condition;

/**
 * 
 * @author Co0sh
 */
public class TagCondition extends Condition {
	
	private String string;
	private boolean inverted = false;

	/**
	 * Constructor method
	 * @param playerID
	 * @param instructions
	 */
	public TagCondition(String playerID, String instructions) {
		super(playerID, instructions);
		String[] parts = instructions.split(" ");
		for (String part : parts) {
			if (part.equalsIgnoreCase("--inverted")) {
				inverted = true;
			}
			if (part.contains("tag:")) {
				string = part.substring(4);
			}
		}
	}

	/* (non-Javadoc)
	 * @see pl.betoncraft.betonquest.core.Condition#isMet()
	 */
	@Override
	public boolean isMet() {
		if (BetonQuest.getInstance().havePlayerString(playerID, string)) {
			return !inverted;
		}
		return inverted;
	}

}