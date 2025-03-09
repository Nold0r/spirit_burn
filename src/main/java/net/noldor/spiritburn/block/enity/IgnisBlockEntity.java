package net.noldor.spiritburn.block.enity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;  
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.noldor.spiritburn.particle.ModParticles;

import java.util.Random;

public class IgnisBlockEntity  extends BlockEntity {
    private static final Random RANDOM = new Random();
    public IgnisBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IGNIS_BLOCK_ENTITY, pos, state);
    }



    public void tick(World world, BlockPos pos, BlockState state) {
        if (!world.isClient) return;
        if (RANDOM.nextFloat() < 0.5) {
            world.addParticle(ModParticles.IGNIS_PARTICE,
                    (double) pos.getX() + 0.45D + (RANDOM.nextFloat() * 0.1D),
                    (double) pos.getY() + 0.45D + (RANDOM.nextFloat() * 0.1D),
                    (double) pos.getZ() + 0.45D + (RANDOM.nextFloat() * 0.1D),
                    RANDOM.nextFloat(-0.005f, 0.005f),
                    RANDOM.nextFloat(-0.002f, 0.02f),
                    RANDOM.nextFloat(-0.005f, 0.005f));
        }


    }
}
