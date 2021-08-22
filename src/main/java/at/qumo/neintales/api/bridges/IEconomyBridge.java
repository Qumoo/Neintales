package at.qumo.neintales.api.bridges;

import net.minecraft.entity.player.EntityPlayerMP;

public interface IEconomyBridge {

    /**
     * Withdraws the specified amount of money from the players account.
     * Only uses the default currency because of Vault.
     *
     * @param player The player which the account belongs to
     * @param amount The amount that should be subtracted
     *
     * @return if the action was performed successfully
     */
    boolean withdraw(EntityPlayerMP player, double amount);

    /**
     * Deposits the specified amount of money to the players account.
     * Only uses the default currency because of Vault.
     *
     * @param player The player which the account belongs to
     * @param amount The amount that should be subtracted
     *
     * @return if the action was performed successfully
     */
    boolean deposit(EntityPlayerMP player, double amount);

    /**
     * Checks if the players account has enough funding
     *
     * @param player The player which the account belongs to
     * @param amount The amount the account should contain
     *
     * @return if the account contains at least the specified amount of money
     */
    boolean has(EntityPlayerMP player, double amount);

    /**
     * Returns the amount of money the player has
     *
     * @param player Player of whom the money should checked
     *
     * @return the balance
     */
    double getBalance(EntityPlayerMP player);
}
