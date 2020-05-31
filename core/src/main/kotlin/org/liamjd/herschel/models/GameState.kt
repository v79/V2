package org.liamjd.herschel.models

/**
 * Game state represents the game in progress. This is the object which will be serialized for saving/loading,
 * and must be static across the entire game
 */
class GameState(player: Player) {

	var year: Int = 2050
	var era = Era.MARS
	var player: Player = player

//	constructor(firstName: String, nickName: String, familyName: String, hq: HQ) {
//		player = Player(1,firstName,familyName,nickName, Gender.MALE, 26)
//	}




}

enum class Era(yearIncrement: Int) {
	MARS(1),
	ASTEROID_BELT(10),
	GAS_GIANTS(20),
	TO_THE_OORT(50),
	CENTAURI(100),
	LOCAL_BUBBLE(1000),
	ORION_CYGNUS_ARM(10000),
	GALACTIC_BAR(100000)
}
