package net.noldor.spiritburn.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


import net.minecraft.util.Identifier;
import net.noldor.spiritburn.Spirit_burn;

public class ModBlocks {

    public static final Block IGNIS = registerBlock("ignis",
            new IgnisBlock(FabricBlockSettings.create()
                    .strength(4f) // Прочность
                    .requiresTool() // Требует инструмент
                    .sounds(IgnisBlock.IGNIS_SOUND_GROUP) // Звуки
                    .mapColor(MapColor.CLEAR) // Цвет карты
                    .luminance(15) // Светимость
                    .dropsNothing() // Не дропает предметы
                    .noCollision() // Без коллизии
                    .nonOpaque() // Прозрачный рендер
                    .noBlockBreakParticles() // Без частиц разрушения
            ));
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Spirit_burn.MOD_ID, name), block);
    };

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Spirit_burn.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

    }

    public static void registerModBlocks() {
        Spirit_burn.LOGGER.info("Registering Mod Block for" + Spirit_burn.MOD_ID);

    }
}

