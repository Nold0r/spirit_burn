package net.noldor.spiritburn;

import net.fabricmc.api.ModInitializer;

import net.noldor.spiritburn.block.ModBlocks;
import net.noldor.spiritburn.block.enity.ModBlockEntities;
import net.noldor.spiritburn.particle.ModParticles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Spirit_burn implements ModInitializer {
	public static final String MOD_ID = "spirit_burn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
		ModParticles.registerModParticles();
	}
}