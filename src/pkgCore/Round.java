package pkgCore;

import java.util.LinkedList;

public class Round {
	private eGameResult eGameResult;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();

	public Round() {
		
		rolls.add(new Roll());
		
		if (isNatural(rolls.getLast().getScore()))
		{
			eGameResult = eGameResult.NATURAL;
		}
		else if (isCraps(rolls.getLast().getScore()))
		{
			eGameResult = eGameResult.CRAPS;
		}
		else
		{
			do {
				rolls.add(new Roll());
			} while ((rolls.getLast().getScore() != 7) || (rolls.getLast().getScore() != rolls.getFirst().getScore()));
		
			if (rolls.getLast().getScore() == 7)
			{
				eGameResult = eGameResult.SEVEN_OUT;
			}
			else if ((rolls.getLast().getScore()) != (rolls.getFirst().getScore()))
					{
				eGameResult = eGameResult.POINT;
					}
		
		
		}	
	
}
	private static boolean isNatural(int iScore) {
		return ((iScore == 7) || (iScore == 11));
	}
	
	private static boolean isCraps(int iScore) {
		return ((iScore == 2) || (iScore == 3) || (iScore == 12));
	}	
	public int RollCount() {
		// Return the roll count
		return rolls.size();
	}
	

	public eGameResult geteGameResult() {
		return eGameResult;
	}
	public int getFirstRoll() {
		return rolls.getFirst().getScore();
	}
	public int getLastRoll() {
		return rolls.getLast().getScore();
	}
}
