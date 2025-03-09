package net.noldor.spiritburn.block.enity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.noldor.spiritburn.Spirit_burn;
import net.noldor.spiritburn.block.ModBlocks;

public class ModBlockEntities {
 public static final BlockEntityType<IgnisBlockEntity> IGNIS_BLOCK_ENTITY =
         Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(Spirit_burn.MOD_ID,"ignis_block_entity"),
                 FabricBlockEntityTypeBuilder.create(IgnisBlockEntity::new,
                         ModBlocks.IGNIS).build());

    public static void registerModBlockEntities() {
        Spirit_burn.LOGGER.info("Registering Mod Block Entities for" + Spirit_burn.MOD_ID);

    }
}
