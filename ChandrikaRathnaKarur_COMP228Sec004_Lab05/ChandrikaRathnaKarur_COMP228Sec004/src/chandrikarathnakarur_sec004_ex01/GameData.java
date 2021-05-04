package chandrikarathnakarur_sec004_ex01;

public class GameData {

	String gameID;
	String gameName;


public GameData(String gameid, String gamename)
{
	this.gameID=gameid;
	this.gameName=gamename;
}

public void setGameID(String gameid)
{
	this.gameID=gameid;
}

public String getGameID()
{
	return this.gameID;
}

public void setGameName(String gamename)
{
	this.gameName=gamename;
}

public String getGameName()
{
	return this.gameName;
}

}//end of class GameData