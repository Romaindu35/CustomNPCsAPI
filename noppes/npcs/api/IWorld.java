package noppes.npcs.api;

import net.minecraft.world.WorldServer;
import noppes.npcs.api.block.IBlock;
import noppes.npcs.api.entity.IEntity;
import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.api.entity.data.IData;
import noppes.npcs.api.item.IItemStack;

public interface IWorld {

	public IEntity[] getNearbyEntities(int x, int y, int z, int range, int type);

	public IEntity getClosestEntity(int x, int y, int z, int range, int type);

	/**
	 * @return The world time
	 */
	public long getTime();

	public void setTime(long time);

	/**
	 * @return The total world time (doesn't change with the /time set command
	 */
	public long getTotalTime();
	
	/**
	 * @return The block at the given position. Returns null if there isn't a block
	 */
	public IBlock getBlock(int x, int y, int z);
	public void setBlock(int x, int y, int z, String name, int meta);
	public void removeBlock(int x, int y, int z);

	/**
	 * @return Returns a value between 0 and 1
	 */
	public float getLightValue(int x, int y, int z);

	/**
	 * @param name The name of the player to be returned
	 * @return The Player with name. Null is returned when the player isnt found
	 */
	public IPlayer getPlayer(String name);

	public boolean isDay();

	public boolean isRaining();
	
	public IDimension getDimension();

	public void setRaining(boolean bo);

	public void thunderStrike(double x, double y, double z);
	
	/**
	 * Sends a packet from the server to the client everytime its called. Probably should not use this too much.
	 * @param particle Particle name. Particle name list: http://minecraft.gamepedia.com/Particles
	 * @param x The x position
	 * @param y The y position
	 * @param z The z position
	 * @param dx Usually used for the x motion
	 * @param dy Usually used for the y motion
	 * @param dz Usually used for the z motion
	 * @param speed Speed of the particles, usually between 0 and 1
	 * @param count Particle count
	 */
	public void spawnParticle(String particle, double x, double y, double z, double dx, double dy, double dz, double speed, int count);

	public void broadcast(String message);

	public IScoreboard getScoreboard();

	/**
	 * Stores any type of data, but will be gone on restart
	 */
	public IData getTempdata();

	/**
	 * Stored data persists through world restart. Unlike tempdata only Strings and Numbers can be saved
	 */
	public IData getStoreddata();

	public IItemStack createItem(String name, int damage, int size);

	
	/**
	 * @param x Position x
	 * @param y Position y
	 * @param z Position z
	 * @param range Range of the explosion
	 * @param fire Whether or not the explosion does fire damage
	 * @param grief Whether or not the explosion does damage to blocks
	 */
	public void explode(double x, double y, double z, float range, boolean fire, boolean grief);

	public IPlayer[] getAllPlayers();

	public String getBiomeName(int x, int z);

	public IEntity spawnClone(double x, double y, double z, int tab, String name);
	
	public IEntity getClone(int tab, String name);

	/**
	 * @return value between 0 and 16
	 */
	public int getRedstonePower(int x, int y, int z);
	
	/**
	 * Expert users only
	 * @return Returns minecrafts world
	 */
	public WorldServer getMCWorld();

	/**
	 * @param uuid entity uuid
	 * @return Returns entity based on uuid
	 */
	public IEntity getEntity(String uuid);

}
