package net.noldor.spiritburn.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.noldor.spiritburn.block.enity.IgnisBlockEntity;
import net.noldor.spiritburn.block.enity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class IgnisBlock extends BlockWithEntity implements BlockEntityProvider {

    private static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D);

    public static final BlockSoundGroup IGNIS_SOUND_GROUP = new BlockSoundGroup(
            0.5F, 2.6F,
            SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE,  // звук разрушения
            SoundEvents.BLOCK_AMETHYST_BLOCK_STEP,       // звук шага
            SoundEvents.BLOCK_AMETHYST_BLOCK_PLACE,     // звук постановки
            SoundEvents.BLOCK_AMETHYST_BLOCK_HIT,       // звук удара
            SoundEvents.BLOCK_AMETHYST_BLOCK_FALL       // звук падения
    );

    protected IgnisBlock(Settings settings) {
        super(settings);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public  BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new IgnisBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.IGNIS_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}

