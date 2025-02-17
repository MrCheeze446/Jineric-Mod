package jingy.jineric.data;

import jingy.jineric.base.JinericMain;
import jingy.jineric.data.generators.JinericBlockLootTableGenerator;
import jingy.jineric.data.generators.JinericModelGenerator;
import jingy.jineric.data.generators.JinericRecipeGenerator;
import jingy.jineric.data.generators.world.JinericWorldGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JinericDataGeneration implements DataGeneratorEntrypoint {

   @Override
   public void onInitializeDataGenerator(FabricDataGenerator generator) {
      FabricDataGenerator.Pack pack = generator.createPack();
      pack.addProvider(JinericRecipeGenerator::new);
      pack.addProvider(JinericModelGenerator::new);
      pack.addProvider(JinericBlockLootTableGenerator::new);
      pack.addProvider(JinericWorldGenerator::new);
   }

   @Override
   public void buildRegistry(RegistryBuilder registryBuilder) {
      registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, JinericWorldGenerator::bootstrap);
   }

   @Override
   public String getEffectiveModId() {
      return JinericMain.MOD_ID;
   }
}


