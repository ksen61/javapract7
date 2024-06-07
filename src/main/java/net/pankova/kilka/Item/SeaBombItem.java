package net.pankova.kilka.Item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pankova.kilka.Kilka;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SeaBombItem extends Item {
    private static final int EXPLOSION_DELAY = 100;
    private static final Map<BlockPos, Integer> bombs = new HashMap<>();

    public SeaBombItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            BlockPos pos = player.blockPosition().relative(player.getDirection(), 2);

            if (!bombs.containsKey(pos)) {
                bombs.put(pos, EXPLOSION_DELAY);
            }
        }

        player.swing(hand);
        itemStack.shrink(1); // Consume the item
        return InteractionResultHolder.success(itemStack);
    }

    @Mod.EventBusSubscriber(modid = Kilka.MOD_ID)
    public static class EventHandler {
        @SubscribeEvent
        public static void onServerTick(TickEvent.ServerTickEvent event) {
            ServerLevel world = event.getServer().overworld();

            if (world == null) return;

            Iterator<Map.Entry<BlockPos, Integer>> iterator = bombs.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<BlockPos, Integer> entry = iterator.next();
                BlockPos pos = entry.getKey();
                int ticksLeft = entry.getValue() - 1;

                if (ticksLeft <= 0) {
                    world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);
                    iterator.remove();
                } else {
                    entry.setValue(ticksLeft);
                }
            }
        }
    }
}
