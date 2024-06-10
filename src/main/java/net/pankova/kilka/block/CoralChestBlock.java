package net.pankova.kilka.block;

import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class CoralChestBlock extends ChestBlock {
    public CoralChestBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD)
                .strength(2.5f)
                .sound(SoundType.WOOD), () -> BlockEntityType.CHEST);
    }
}
