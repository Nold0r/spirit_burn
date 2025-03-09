package net.noldor.spiritburn.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.noldor.spiritburn.Spirit_burn;

public class ModParticles {
    public static final  DefaultParticleType IGNIS_PARTICE =
            registerParticle("ignis_particle", FabricParticleTypes.simple(true));

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType){

        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Spirit_burn.MOD_ID, name), particleType);
    }
    public static void registerModParticles() {
        Spirit_burn.LOGGER.info("Registering Mod Particle for" + Spirit_burn.MOD_ID);

    }
}
