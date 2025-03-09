package net.noldor.spiritburn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.noldor.spiritburn.particle.IgnisParticle;
import net.noldor.spiritburn.particle.ModParticles;


public class Spirit_burn_Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.IGNIS_PARTICE, IgnisParticle.Factory::new);
    }

}
