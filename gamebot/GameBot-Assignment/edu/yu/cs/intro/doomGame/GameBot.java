package edu.yu.cs.intro.doomGame;

import java.util.SortedSet;

/**
 * Plays through a given game scenario. i.e. tries to kill all the monsters in all the rooms and thus complete the game, using the given set of players
 */
public class GameBot {

    /**
     * Create a new "GameBot", i.e. a program that automatically "plays the game"
     * @param rooms the set of rooms in this game
     * @param players the set of players the bot can use to try to complete all rooms
     */
    public GameBot(SortedSet<Room> rooms, SortedSet<Player> players) {
        this.rooms = rooms;
        this.players = players;
    }

    /**
     * Try to complete killing all monsters in all rooms using the given set of players.
     * It could take multiple passes through the set of rooms to complete the task of killing every monster in every room.
     * This method should call #passThroughRooms in some loop that tracks whether all the rooms have been completed OR we
     * have reached a point at which no progress can be made. If we are "stuck", i.e. we haven't completed all rooms but
     * calls to #passThroughRooms are no longer increasing the number of rooms that have been completed, return false to
     * indicate that we can't complete the game. As long as the number of completed rooms continues to rise, keep calling
     * #passThroughRooms.
     *
     * Throughout our attempt/logic to play the game, we rely on and take advantage of the fact that Room, Monster,
     * and Player all implement Comparable, and the sets we work with are all SortedSets
     *
     * @return true if all rooms were completed, false if not
     */
    public boolean play() {
    }

    /**
     * Pass through the rooms, killing any monsters that can be killed, and thus attempt to complete the rooms
     * @return the set of rooms that were completed in this pass
     */
    protected Set<Room> passThroughRooms() {
        //for every room that is not completed,
            //for every living monster in that room
                //See if any of your players can kill the monster. If so, have the capable player kill it.
                //The player that causes the room to be completed by killing a monster reaps the rewards for completing that room.
        //Return the set of completed rooms.
    }

    /**
     * give the player the weapons, ammunition, and health that come from completing the given room
     * @param player
     * @param room
     */
    protected void reapCompletionRewards(Player player, Room room) {
    }

    /**
     * Have the given player kill the given monster in the given room.
     * Assume that #canKill was already called to confirm that player's ability to kill the monster
     * @param player
     * @param room
     * @param monsterToKill
     */
    protected void killMonster(Player player, Room room, Monster monsterToKill) {
        //Call getAllProtectorsInRoom to get a sorted set of all the monster's protectors in this room
        //Player must kill the protectors before it can kill the monster, so kill all the protectors
        //first via a recursive call to killMonster on each one.
        //Reduce the player's health by the amount given by room.getPlayerHealthLostPerEncounter().
        //Attack (and thus kill) the monster with the kind of weapon, and amount of ammunition, needed to kill it.
    }

    /**
     * @return a set of all the rooms that have been completed
     */
    public Set<Room> getCompletedRooms() {
    }

    /**
     * @return an unmodifiable collection of all the rooms in the came
     * @see java.util.Collections#unmodifiableSortedSet(SortedSet)
     */
    public SortedSet<Room> getAllRooms() {
    }

    /**
     * @return a sorted set of all the live players in the game
     */
    protected SortedSet<Player> getLivePlayers() {
    }

    /**
     * @param weapon
     * @param ammunition
     * @return a sorted set of all the players that have the given wepoan with the given amount of ammunition for it
     */
    protected SortedSet<Player> getLivePlayersWithWeaponAndAmmunition(Weapon weapon, int ammunition) {
    }

    /**
     * Get the set of all monsters that would need to be killed first before you could kill this one.
     * Remember that a protector may itself be protected by other monsters, so you will have to recursively check for protectors
     * @param monster
     * @param room
     * @return
     */
    protected static SortedSet<Monster> getAllProtectorsInRoom(Monster monster, Room room) {
        return getAllProtectorsInRoom(new TreeSet<Monster>(), monster, room); //this is a hint about how to handle canKill as well
    }

    private static SortedSet<Monster> getAllProtectorsInRoom(SortedSet<Monster> protectors, Monster monster, Room room) {
    }

    /**
     * Can the given player kill the given monster in the given room?
     *
     * @param player
     * @param monster
     * @param room
     * @return
     * @throws IllegalArgumentException if the monster is not located in the room or is dead
     */
    protected static boolean canKill(Player player, Monster monster, Room room) {
        //Going into the room exposes the player to all the monsters in the room. If the player's health is
        //not > room.getPlayerHealthLostPerEncounter(), you can return immediately.
        //Call the private canKill method, to determine if this player can kill this monster.
        //Before returning from this method, reset the player's health to what it was before you called the private canKill
    }

    /**
     *
     * @param player
     * @param monster
     * @param room
     * @param roundsUsedPerWeapon
     * @return
     */
    private static boolean canKill(Player player, Monster monster, Room room, SortedMap<Weapon, Integer> roundsUsedPerWeapon, Set<Monster> alreadyMarkedByCanKill) {
        //Remove all the monsters already marked / looked at by this series of recursive calls to canKill from the set of liveMonsters
        // in the room before you check if the monster is alive and in the room. Be sure to NOT alter the actual set of live monsters in your Room object!
        //Check if monster is in the room and alive.
        //Check what weapon is needed to kill the monster, see if player has it. If not, return false.
        //Check what protects the monster. If the monster is protected, the player can only kill this monster if it can kill its protectors as well.
        //Make recursive calls to canKill to see if player can kill its protectors.
        //Be sure to remove all members of alreadyMarkedByCanKill from the set of protectors before you recursively call canKill on the protectors.
        //If all the recursive calls to canKill on all the protectors returned true:
        //Check what amount of ammunition is needed to kill the monster, and see if player has it after we subtract
        //from his total ammunition the number stored in roundsUsedPerWeapon for the given weapon, if any.
        //add how much ammunition will be used up to kill this monster to roundsUsedPerWeapon
        //Add up the playerHealthLostPerExposure of all the live monsters, and see if when that is subtracted from the player if his health is still > 0. If not, return false.
        //If health is still > 0, subtract the above total from the player's health
        //(Note that in the protected canKill method, you must reset the player's health to what it was before canKill was called before you return from that protected method)
        //add this monster to alreadyMarkedByCanKill, and return true.
    }

}
